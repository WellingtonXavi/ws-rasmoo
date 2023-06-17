package com.client.ws.rasmooplus.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.client.ws.rasmooplus.api.dto.UserDto;
import com.client.ws.rasmooplus.api.dto.input.UserInput;
import com.client.ws.rasmooplus.domain.model.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserMapper {

	private ModelMapper mapper;

	public User toEntity(UserInput userInput)
	{
	
		
		return this.mapper.map(userInput, User.class);
	}
	
	public UserDto toModel(User user)
	{
		return this.mapper.map(user, UserDto.class);
	}
	               

}
