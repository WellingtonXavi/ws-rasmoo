package com.client.ws.rasmooplus.domain.service;

import com.client.ws.rasmooplus.api.dto.TokenDto;
import com.client.ws.rasmooplus.api.dto.input.LoginInput;

public interface AuthenticationService {
	
	
	TokenDto auth(LoginInput loginInput);
	
	
	

}
