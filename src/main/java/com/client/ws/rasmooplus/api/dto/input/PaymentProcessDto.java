package com.client.ws.rasmooplus.api.dto.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentProcessDto {
	
	@NotBlank
	private String productKey;
	
	private BigDecimal discount;
	
	@NotNull
	@JsonProperty("userPaymentInfo")
	private UserPaymentInfoInput infoInput;

}
