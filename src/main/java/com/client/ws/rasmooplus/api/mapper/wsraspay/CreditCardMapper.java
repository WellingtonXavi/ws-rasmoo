package com.client.ws.rasmooplus.api.mapper.wsraspay;

import com.client.ws.rasmooplus.api.dto.input.UserPaymentInfoInput;
import com.client.ws.rasmooplus.api.dto.raspay.CreditCardDto;

public class CreditCardMapper {
	
	public static CreditCardDto build(UserPaymentInfoInput infoInput , String documentNumber)
	{
		return CreditCardDto.builder()
				.documentNumber(documentNumber)
				.cvv( Long.parseLong(infoInput.getCardSecurityCode()))
				.number(infoInput.getCardNumber())
				.month(infoInput.getCardExpirationMonth())
				.year(infoInput.getCardExpirationYear())	
				.installments(infoInput.getInstalments())
				.build();
	}

}
