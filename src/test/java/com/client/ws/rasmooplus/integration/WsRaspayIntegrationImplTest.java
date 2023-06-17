package com.client.ws.rasmooplus.integration;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.client.ws.rasmooplus.api.dto.raspay.CreditCardDto;
import com.client.ws.rasmooplus.api.dto.raspay.CustomerDto;
import com.client.ws.rasmooplus.api.dto.raspay.OrderDto;
import com.client.ws.rasmooplus.api.dto.raspay.PaymentDto;
import com.client.ws.rasmooplus.api.integration.WsRaspayIntegration;

@SpringBootTest
public class WsRaspayIntegrationImplTest {

	@Autowired
	private WsRaspayIntegration integration;

	@Test
	void createCustomerWhenDtoOk() {

		CustomerDto customerDto = new CustomerDto();

		customerDto.setCpf("58440833008");
		customerDto.setEmail("wellington@hotmail.com");
		customerDto.setFirstName("Wellington");
		customerDto.setLastName("Xavier dos Santos");

		integration.createCustomer(customerDto);

	}

	@Test
	void createOrderWhenDtoOk() {

		OrderDto orderdto = new OrderDto();

		orderdto.setProductAcronym("MONTH22");
		orderdto.setCustomerId("64591739ce28bb1a6cd0d031");
		orderdto.setDiscount(BigDecimal.ZERO);

		integration.createOrder(orderdto);

	}
	
	
	
	@Test
	void processPaymentWhenDtoOk() {
		
		CreditCardDto cardDto = new CreditCardDto();
		cardDto.setCvv(123l);
		cardDto.setDocumentNumber("58440833008");
		cardDto.setInstallments(0l);
		cardDto.setMonth(12l);
		cardDto.setNumber("12345678");
		cardDto.setYear(2023l);
		
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setCreditCard(cardDto);
		paymentDto.setCustomerId("64591739ce28bb1a6cd0d031");
		paymentDto.setOrderId("645933f29b2cfd34a8f09d56");
		



		integration.processPayment(paymentDto);

	}

}
