package com.client.ws.rasmooplus.api.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.ws.rasmooplus.api.dto.TokenDto;
import com.client.ws.rasmooplus.api.dto.input.LoginInput;
import com.client.ws.rasmooplus.domain.service.AuthenticationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AutenticationController {

	private AuthenticationService authenticationService;

	@PostMapping
	public ResponseEntity<TokenDto> auth(@RequestBody @Valid LoginInput loginInput) {
		
		
		return ResponseEntity.ok( this.authenticationService.auth(loginInput));

	

		
	}
	
	
	

	

}
