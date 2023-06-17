package com.client.ws.rasmooplus.domain.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.domain.exception.NotFoundException;
import com.client.ws.rasmooplus.domain.model.UserCredentials;
import com.client.ws.rasmooplus.domain.repository.UserCredentialsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserCredentialsServiceImpl implements UserDetailsService {

	private UserCredentialsRepository userCredentialsRepository;
	
	

	
	  @Override public UserDetails loadUserByUsername(String username) throws
	  UsernameNotFoundException {
	  
	  UserCredentials userCredentials =
	  this.userCredentialsRepository.findByUserName(username) .orElseThrow( () -> new
	  NotFoundException("Usuário ou senha incorretos") );
	  
	  return userCredentials;
	  
	  
	  }
	 


}
