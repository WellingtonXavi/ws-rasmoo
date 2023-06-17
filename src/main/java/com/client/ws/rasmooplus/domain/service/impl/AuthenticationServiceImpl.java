package com.client.ws.rasmooplus.domain.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.api.dto.TokenDto;
import com.client.ws.rasmooplus.api.dto.input.LoginInput;
import com.client.ws.rasmooplus.domain.exception.BadRequestException;
import com.client.ws.rasmooplus.domain.service.AuthenticationService;
import com.client.ws.rasmooplus.domain.service.TokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private AuthenticationManager authenticationManager;
	private TokenService tokenService;

	@Override
	public TokenDto auth(LoginInput loginInput) {
		
		try {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
					loginInput.getUserName(), loginInput.getPassword());

			Authentication auth = authenticationManager.authenticate(authentication);

			String token = this.tokenService.getToken(auth);
			
			TokenDto dto = new TokenDto(token , "Bearer");
			
			return dto;
			
		}catch (Exception e) {
			throw new BadRequestException("Erro ao formatar o token " + e.getMessage());
		}
		
		
	}

}
