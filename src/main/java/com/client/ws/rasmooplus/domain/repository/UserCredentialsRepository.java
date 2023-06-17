package com.client.ws.rasmooplus.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.ws.rasmooplus.domain.model.UserCredentials;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
	
	
	
	Optional<UserCredentials> findByUserName(String username);
	

}
