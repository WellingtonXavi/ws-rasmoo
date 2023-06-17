package com.client.ws.rasmooplus.domain.service;

import com.client.ws.rasmooplus.api.dto.input.PaymentProcessDto;

public interface PaymentInfoService {
	
	
	Boolean process(PaymentProcessDto dto);

}
