package com.client.ws.rasmooplus.api.dto.input;

import java.time.OffsetDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {

	private Long id;

	@NotBlank
	private String name;

	@Email
	private String email;

	@Size(min = 11 )
	private String phone;

	@CPF
	private String cpf;

	
	private OffsetDateTime dtSubscription = OffsetDateTime.now();

	private OffsetDateTime dtExpiration = OffsetDateTime.now();


	@NotNull
	private Long userTypeId;
	

}
