package com.client.ws.rasmooplus.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.ws.rasmooplus.api.dto.input.PaymentProcessDto;
import com.client.ws.rasmooplus.domain.service.PaymentInfoService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentInfoController {
	
	
	private PaymentInfoService paymentInfoService;
	
	@PostMapping("/process")
	public ResponseEntity<Boolean> process(@RequestBody PaymentProcessDto  dto )
	{
		return ResponseEntity.status(HttpStatus.OK).body(paymentInfoService.process(dto));
	}

}
