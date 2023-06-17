package com.client.ws.rasmooplus.api.integration;

import com.client.ws.rasmooplus.api.dto.raspay.CustomerDto;
import com.client.ws.rasmooplus.api.dto.raspay.OrderDto;
import com.client.ws.rasmooplus.api.dto.raspay.PaymentDto;

public interface WsRaspayIntegration {
	
	
	CustomerDto createCustomer(CustomerDto customerDto);
	
	OrderDto createOrder(OrderDto orderDto);
	
	Boolean processPayment(PaymentDto paymentDto);
	

}
