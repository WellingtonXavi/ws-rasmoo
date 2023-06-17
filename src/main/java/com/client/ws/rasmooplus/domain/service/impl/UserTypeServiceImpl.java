package com.client.ws.rasmooplus.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.domain.exception.NotFoundException;
import com.client.ws.rasmooplus.domain.model.UserType;
import com.client.ws.rasmooplus.domain.repository.UserTypeRepository;
import com.client.ws.rasmooplus.domain.service.UserTypeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {

	private UserTypeRepository repository;

	@Override
	public UserType create(UserType userType) {

		return this.repository.save(userType);
	}

	@Override
	public UserType findById(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("UserType com id " + id + " não localizado"));
	}

	@Override
	public UserType update(Long id, UserType userType) {
		
		return null;
	}

	@Override
	public List<UserType> findAll() {
		return this.repository.findAll();
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
		
	}

}
