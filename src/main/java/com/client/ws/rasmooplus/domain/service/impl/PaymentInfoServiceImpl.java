package com.client.ws.rasmooplus.domain.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.api.dto.input.PaymentProcessDto;
import com.client.ws.rasmooplus.api.dto.raspay.CustomerDto;
import com.client.ws.rasmooplus.api.dto.raspay.OrderDto;
import com.client.ws.rasmooplus.api.dto.raspay.PaymentDto;
import com.client.ws.rasmooplus.api.integration.MailIntegration;
import com.client.ws.rasmooplus.api.integration.WsRaspayIntegration;
import com.client.ws.rasmooplus.api.mapper.UserPaymentInfoMapper;
import com.client.ws.rasmooplus.api.mapper.wsraspay.CreditCardMapper;
import com.client.ws.rasmooplus.api.mapper.wsraspay.CustomerMapper;
import com.client.ws.rasmooplus.api.mapper.wsraspay.OrderMapper;
import com.client.ws.rasmooplus.api.mapper.wsraspay.PaymentMapper;
import com.client.ws.rasmooplus.domain.enums.UserTypeEnum;
import com.client.ws.rasmooplus.domain.exception.BusinessException;
import com.client.ws.rasmooplus.domain.exception.NotFoundException;
import com.client.ws.rasmooplus.domain.model.SubscriptionType;
import com.client.ws.rasmooplus.domain.model.User;
import com.client.ws.rasmooplus.domain.model.UserCredentials;
import com.client.ws.rasmooplus.domain.model.UserPaymentInfo;
import com.client.ws.rasmooplus.domain.model.UserType;
import com.client.ws.rasmooplus.domain.repository.SubscriptionTypeRepository;
import com.client.ws.rasmooplus.domain.repository.UserCredentialsRepository;
import com.client.ws.rasmooplus.domain.repository.UserPaymentInfoRepository;
import com.client.ws.rasmooplus.domain.repository.UserRepository;
import com.client.ws.rasmooplus.domain.repository.UserTypeRepository;
import com.client.ws.rasmooplus.domain.service.PaymentInfoService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentInfoServiceImpl implements PaymentInfoService {

	// @Value("${webservices.rasplus.default.password}")
	private final static String defaultPass = "alunrasmoo";

	private final UserRepository userRepository;
	private final UserPaymentInfoRepository paymentInfoRepository;
	private final WsRaspayIntegration wsRaspayIntegration;
	private final MailIntegration mailIntegration;
	private final UserCredentialsRepository userCredentialsRepository;
	private final UserTypeRepository userTypeRepository;
	private final SubscriptionTypeRepository subscriptionTypeRepository;

	@Override
	public Boolean process(PaymentProcessDto dto) {

		// verificar usuario por id e verifica se possui assinatura

		var userOpt = this.userRepository.findById(dto.getInfoInput().getUserId());
		if (userOpt.isEmpty()) {
			throw new NotFoundException("Usuário não encontrado.");
		}

		User user = userOpt.get();

		if (Objects.nonNull(user.getSubscriptionType())) {
			throw new BusinessException("Pagamento não pode ser processado, pois o usuário já possui assinatura.");
		}

		// cria ou atualiza no raspay

		CustomerDto customerDto = CustomerMapper.build(user);
		customerDto = this.wsRaspayIntegration.createCustomer(customerDto);

		// cria o pedido de pagamento

		OrderDto orderDto = this.wsRaspayIntegration.createOrder(OrderMapper.build(customerDto.getId(), dto));

		// processa e retorna o pagamento

		PaymentDto paymentDto = PaymentMapper.build(customerDto.getId(), orderDto.getId(),
				CreditCardMapper.build(dto.getInfoInput(), user.getCpf()));
		boolean sucessPayment = this.wsRaspayIntegration.processPayment(paymentDto);

		// salvar informações de pagamento
		if (sucessPayment) {
			UserPaymentInfo userPaymentInfo = UserPaymentInfoMapper.toEntity(dto.getInfoInput(), user);

			UserType userType = this.userTypeRepository.findById(UserTypeEnum.ALUNO.getId())
					.orElseThrow(() -> new NotFoundException("User Type não encontrado"));

			SubscriptionType subscriptionType = this.subscriptionTypeRepository.findByProductKey(dto.getProductKey())
					.orElseThrow(() -> new NotFoundException("User Type não encontrado"));
			
			user.setSubscriptionType(subscriptionType);
			
			
			this.userRepository.save(user);

			this.userCredentialsRepository.save(new UserCredentials(null, user.getEmail().trim(),
					new BCryptPasswordEncoder().encode(defaultPass), userType));

			paymentInfoRepository.save(userPaymentInfo);
			 mailIntegration.send(user.getEmail(), "LOGIN: " +user.getEmail() + "SENHA: "
			 + defaultPass, "ACESSO LIBERADO");
			return true;
		}

		return false;
	}

}
