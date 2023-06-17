package com.client.ws.rasmooplus.api.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubscriptionTypeDto {
	
	

	
	private Long id;
	
	
	private String name;
	
	private Integer accessMonths;
	
	private BigDecimal price;
	
	private String productKey;

}
