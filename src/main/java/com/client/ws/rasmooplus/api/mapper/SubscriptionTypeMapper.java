package com.client.ws.rasmooplus.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.client.ws.rasmooplus.api.dto.SubscriptionTypeDto;
import com.client.ws.rasmooplus.api.dto.input.SubscriptionTypeInput;
import com.client.ws.rasmooplus.domain.model.SubscriptionType;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SubscriptionTypeMapper {

	private   ModelMapper mapper;
	


	public  SubscriptionType toEntity(SubscriptionTypeInput subscriptionTypeInput) {
		return mapper.map(subscriptionTypeInput, SubscriptionType.class);
	}

	public  SubscriptionTypeDto toModel(SubscriptionType subscriptionType) {
		return mapper.map(subscriptionType, SubscriptionTypeDto.class);
	}

	public  List<SubscriptionTypeDto> toCollections(List<SubscriptionType> subscriptionTypes) {
		List<SubscriptionTypeDto> subscriptionTypeDtos = new ArrayList<>();

		for (SubscriptionType subscriptionType : subscriptionTypes) {

			subscriptionTypeDtos.add(toModel(subscriptionType));

		}

		return subscriptionTypeDtos;
	}
}
