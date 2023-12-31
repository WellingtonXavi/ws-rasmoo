package com.client.ws.rasmooplus.domain.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.domain.model.UserCredentials;
import com.client.ws.rasmooplus.domain.service.TokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TokenServiceImpl implements TokenService {

	@Value("${webservices.rasplus.jwt.experation}")
	private String expiration;

	@Value("${webservices.rasplus.jwt.secret}")
	private String secret;

	@Override
	public String getToken(Authentication auth) {

		UserCredentials user = ((UserCredentials) auth.getPrincipal());

		Date today = new Date();
		Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));

		return Jwts.builder()
				.setIssuer("API Rasmoo Plus")
				.setSubject(user.getId().toString())
				.setIssuedAt(today)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	@Override
	public Boolean isValid(String token) {
		
		try {
			getClaimsJws(token);
			return true;
		}catch (Exception e) {
		
			return false;
		}
		
	}

	@Override
	public Long getUserId(String token) {
		
	Jws<Claims> jws = getClaimsJws(token);
	return Long.parseLong( jws.getBody().getSubject());
		
	}

	private Jws<Claims> getClaimsJws(String token) {
		 return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
