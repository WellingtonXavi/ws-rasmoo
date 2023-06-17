package com.client.ws.rasmooplus.api.mapper.wsraspay;

import com.client.ws.rasmooplus.api.dto.raspay.CreditCardDto;
import com.client.ws.rasmooplus.api.dto.raspay.PaymentDto;

public class PaymentMapper {
	
	public static PaymentDto build(String customerId , String orderId, CreditCardDto cardDto)
	{
		return PaymentDto.builder()
				.customerId(customerId)
				.orderId(orderId)
				.creditCard(cardDto) 				
				.build();
	}

}

	