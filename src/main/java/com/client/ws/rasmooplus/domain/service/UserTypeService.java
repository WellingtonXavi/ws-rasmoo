package com.client.ws.rasmooplus.domain.service;

import java.util.List;

import com.client.ws.rasmooplus.domain.model.UserType;

public interface UserTypeService {
	
	
	UserType create(UserType userType);
	
	UserType findById(Long id);
	
	UserType update(Long id , UserType userType);
	
	List<UserType> findAll();
	
	void delete(Long id);

}
