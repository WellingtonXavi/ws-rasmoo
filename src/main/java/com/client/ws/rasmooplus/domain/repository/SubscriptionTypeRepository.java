package com.client.ws.rasmooplus.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.ws.rasmooplus.domain.model.SubscriptionType;

@Repository
public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Long> {
	
	
	
			Optional<SubscriptionType> findByProductKey(String productKey);
}
