package com.client.ws.rasmooplus.api.dto.input;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionTypeInput {
	
	
	private Long id;
	
	@NotBlank	
	private String name;
	
	@NotNull
	@Max(value = 12)
	@Min(value = 1)
	private Integer accessMonths;
	
	@NotNull
	private BigDecimal price;
	
	@NotBlank
	private String productKey;

}
