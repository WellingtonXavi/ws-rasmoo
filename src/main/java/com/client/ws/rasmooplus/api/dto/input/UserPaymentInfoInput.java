package com.client.ws.rasmooplus.api.dto.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPaymentInfoInput {

	
	
	private Long id;

	@Size(max = 16 , min = 16)
	private String cardNumber;

	@Min(value = 1)
	@Max(value = 12)
	private Long cardExpirationMonth;

	
	private Long cardExpirationYear;

	@Size(min = 3 , max = 3)
	private String cardSecurityCode;

	private BigDecimal price;

	private Long instalments;

	private OffsetDateTime dtPayment = OffsetDateTime.now();
	
	@NotNull
	private Long userId;
}
