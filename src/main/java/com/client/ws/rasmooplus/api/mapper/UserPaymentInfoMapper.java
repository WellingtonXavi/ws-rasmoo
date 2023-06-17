package com.client.ws.rasmooplus.api.mapper;

import org.springframework.stereotype.Component;

import com.client.ws.rasmooplus.api.dto.input.UserPaymentInfoInput;
import com.client.ws.rasmooplus.domain.model.User;
import com.client.ws.rasmooplus.domain.model.UserPaymentInfo;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserPaymentInfoMapper {
	
	
	
	public static UserPaymentInfo toEntity(UserPaymentInfoInput infoInput, User user)
	{
		return UserPaymentInfo.builder()
				.instalments(infoInput.getInstalments())
				.cardNumber(infoInput.getCardNumber())
				.id(infoInput.getId())
				.cardExpirationMonth(infoInput.getCardExpirationMonth())
				.cardExpirationYear(infoInput.getCardExpirationYear())
				.cardSecurityCode(infoInput.getCardSecurityCode())
				.price(infoInput.getPrice())
				.dtPayment(infoInput.getDtPayment())
				.user(user)
				
				
				.build();
	}
}
