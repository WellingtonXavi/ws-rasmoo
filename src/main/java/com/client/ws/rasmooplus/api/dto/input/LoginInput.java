package com.client.ws.rasmooplus.api.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInput {
	
	@NotBlank
	private String userName;
	@NotBlank
	private String password;
	
	
	
	
	

}
