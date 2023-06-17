package com.client.ws.rasmooplus.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.ws.rasmooplus.api.dto.SubscriptionTypeDto;
import com.client.ws.rasmooplus.api.dto.input.SubscriptionTypeInput;
import com.client.ws.rasmooplus.api.mapper.SubscriptionTypeMapper;
import com.client.ws.rasmooplus.domain.model.SubscriptionType;
import com.client.ws.rasmooplus.domain.service.SubscriptionTypeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/subscriptionType")
@AllArgsConstructor
public class SubscriptionTypeController {

	private SubscriptionTypeService subscriptionTypeService;

	private SubscriptionTypeMapper mapper;

	@GetMapping
	@Cacheable(value = "subscriptionType")
	public ResponseEntity<List<SubscriptionTypeDto>> findAll() {

		return ResponseEntity.ok(this.mapper.toCollections(this.subscriptionTypeService.findAll()));
	}

	@GetMapping("/{id}")
	@Cacheable(value = "subscriptionType" , key = "#id")
	public ResponseEntity<SubscriptionTypeDto> findById(@PathVariable Long id) {

		SubscriptionType subscriptionType = this.subscriptionTypeService.findById(id);

		return ResponseEntity.ok(this.mapper.toModel(subscriptionType));
	}

	@PutMapping("/{id}")
	@CacheEvict(value = "subscriptionType" , allEntries = true)
	public ResponseEntity<SubscriptionTypeDto> update(@RequestBody SubscriptionTypeInput subscriptionTypeInput , @PathVariable Long id) {

		SubscriptionType subscriptionType = mapper.toEntity(subscriptionTypeInput);

		subscriptionType = this.subscriptionTypeService.update(id , subscriptionType );

		SubscriptionTypeDto typeDto = mapper.toModel(subscriptionType);

		return ResponseEntity.status(HttpStatus.OK).body(typeDto);
	}

	@PostMapping
	@CacheEvict(value = "subscriptionType" , allEntries = true)
	public ResponseEntity<SubscriptionTypeDto> create(@RequestBody @Valid SubscriptionTypeInput subscriptionTypeInput) {
		
		

		SubscriptionType subscriptionType = mapper.toEntity(subscriptionTypeInput);

		subscriptionType = this.subscriptionTypeService.create(subscriptionType);

		SubscriptionTypeDto typeDto = mapper.toModel(subscriptionType);

		return ResponseEntity.status(HttpStatus.CREATED).body(typeDto);
	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "subscriptionType" , allEntries = true)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.subscriptionTypeService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
