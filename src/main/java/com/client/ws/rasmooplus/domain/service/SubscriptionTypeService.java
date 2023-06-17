package com.client.ws.rasmooplus.domain.service;

import java.util.List;

import com.client.ws.rasmooplus.domain.model.SubscriptionType;

public interface SubscriptionTypeService {

	List<SubscriptionType> findAll();

	SubscriptionType findById(Long id);

	SubscriptionType create(SubscriptionType subscriptionType);

	SubscriptionType update(Long id, SubscriptionType subscriptionType);
	
	void delete(Long id);

}
