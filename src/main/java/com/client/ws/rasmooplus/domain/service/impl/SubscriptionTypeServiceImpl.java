package com.client.ws.rasmooplus.domain.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.domain.exception.BadRequestException;
import com.client.ws.rasmooplus.domain.exception.NotFoundException;
import com.client.ws.rasmooplus.domain.model.SubscriptionType;
import com.client.ws.rasmooplus.domain.repository.SubscriptionTypeRepository;
import com.client.ws.rasmooplus.domain.service.SubscriptionTypeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

	private SubscriptionTypeRepository subscriptionTypeRepository;

	@Override
	public List<SubscriptionType> findAll() {
		return this.subscriptionTypeRepository.findAll();
	}

	@Override
	public SubscriptionType findById(Long id) {

		return this.subscriptionTypeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Subscription Type com o id " + id + " não localizado."));

	}

	@Override
	public SubscriptionType create(SubscriptionType subscriptionType) {
		
		System.err.println(subscriptionType.getId());
		if(Objects.nonNull(subscriptionType.getId()))
		{
			throw new BadRequestException("O campo ID não deve ser informado.");
		}
		return this.subscriptionTypeRepository.save(subscriptionType);
	}

	@Override
	public SubscriptionType update(Long id, SubscriptionType subscriptionType) {
		
		 this.findById(id);
		
		subscriptionType.setId(id); 		
		
		return this.subscriptionTypeRepository.save(subscriptionType);
	}

	@Override
	public void delete(Long id) {
		
		this.findById(id);
		
		this.subscriptionTypeRepository.deleteById(id);

	}

}
