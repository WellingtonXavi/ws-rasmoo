package com.client.ws.rasmooplus.api.mapper.wsraspay;

import com.client.ws.rasmooplus.api.dto.raspay.CustomerDto;
import com.client.ws.rasmooplus.domain.model.User;

public class CustomerMapper {

	public static CustomerDto build(User user) {
		var fullName = user.getName().split(" ");
		var firstName = fullName[0];
		var lastName = fullName.length > 1 ? fullName[fullName.length - 1] : "";

		return CustomerDto.builder()
				.cpf(user.getCpf().trim())
				.email(user.getEmail().trim())
				.firstName(firstName)
				.lastName(lastName)
				.build();

	}

}
