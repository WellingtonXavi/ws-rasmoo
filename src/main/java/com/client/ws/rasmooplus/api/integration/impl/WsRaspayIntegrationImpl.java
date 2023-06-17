package com.client.ws.rasmooplus.api.integration.impl;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.client.ws.rasmooplus.api.dto.raspay.CustomerDto;
import com.client.ws.rasmooplus.api.dto.raspay.OrderDto;
import com.client.ws.rasmooplus.api.dto.raspay.PaymentDto;
import com.client.ws.rasmooplus.api.integration.WsRaspayIntegration;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

	private final RestTemplate restTemplate;
	private final HttpHeaders headers;
	
	@Value("${webservices.raspay.host}")
	private String raspayHost;
	
	@Value("${webservices.raspay.v1.customer}")
	private String customerUrl;
	
	@Value("${webservices.raspay.v1.order}")
	private String orderUrl;
	
	@Value("${webservices.raspay.v1.payment}")
	private String paymentUrl;
	

	
	

	public WsRaspayIntegrationImpl() {
		restTemplate = new RestTemplate();
		headers = getHttpHeader();

	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {

		try {

			HttpEntity<CustomerDto> request = new HttpEntity<>(customerDto, this.headers);

			ResponseEntity<CustomerDto> response = restTemplate.exchange(raspayHost+customerUrl ,
					HttpMethod.POST, request, CustomerDto.class);

			System.err.println("CLIENTE "+response.getBody().getId());
			return response.getBody();
		} catch (Exception e) {

			throw e;
		}
	}

	@Override
	public OrderDto createOrder(OrderDto orderDto) {

		try {

			HttpEntity<OrderDto> request = new HttpEntity<>(orderDto, this.headers);

			ResponseEntity<OrderDto> response = restTemplate.exchange(raspayHost+orderUrl,
					HttpMethod.POST, request, OrderDto.class);

			System.err.println("PEDIDO " + response.getBody().getId());
			return response.getBody();
		} catch (Exception e) {

			throw e;
		}

	}

	@Override
	public Boolean processPayment(PaymentDto paymentDto) {
		try {

			HttpEntity<PaymentDto> request = new HttpEntity<>(paymentDto, this.headers);

			ResponseEntity<Boolean> response = restTemplate.exchange(
					raspayHost+paymentUrl, HttpMethod.POST, request, Boolean.class);

			return response.getBody();
		} catch (Exception e) {

			throw e;
		}

	}

	private HttpHeaders getHttpHeader() {
		String credential = "rasmooplus:r@sm00";
		String base64 = new String(Base64.encodeBase64(credential.getBytes()));

		HttpHeaders headers = new HttpHeaders();

		headers.add("Authorization", "Basic " + base64);
		return headers;
	}

}
