package com.client.ws.rasmooplus.api.mapper.wsraspay;

import com.client.ws.rasmooplus.api.dto.input.PaymentProcessDto;
import com.client.ws.rasmooplus.api.dto.raspay.OrderDto;


public class OrderMapper {
	
	
	
	public static OrderDto build(String customerId , PaymentProcessDto processDto)
	{
		return   OrderDto.builder()
				.productAcronym(processDto.getProductKey())
				.customerId(customerId)
				.discount(processDto.getDiscount())				
				.build();
	}
	

}
