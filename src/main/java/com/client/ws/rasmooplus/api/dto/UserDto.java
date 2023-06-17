package com.client.ws.rasmooplus.api.dto;

import java.time.OffsetDateTime;

import com.client.ws.rasmooplus.domain.model.SubscriptionType;
import com.client.ws.rasmooplus.domain.model.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class UserDto {
	
	

	private Long id;

	private String name;

	private String email;

	private String phone;

	private String cpf;

	private OffsetDateTime dtSubscription = OffsetDateTime.now();

	private OffsetDateTime dtExpiration = OffsetDateTime.now();
;

	private UserType type;

	private SubscriptionType subscriptionType;

}
