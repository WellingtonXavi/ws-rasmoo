package com.client.ws.rasmooplus.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.ws.rasmooplus.api.dto.UserDto;
import com.client.ws.rasmooplus.api.dto.input.UserInput;
import com.client.ws.rasmooplus.api.mapper.UserMapper;
import com.client.ws.rasmooplus.domain.model.User;
import com.client.ws.rasmooplus.domain.service.UserService;

import lombok.AllArgsConstructor;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {

	private UserService userService;
	private UserMapper userMapper;

	@PostMapping
	public ResponseEntity<UserDto> create(@RequestBody @Valid UserInput userInput) {
		User user = this.userMapper.toEntity(userInput);

		return ResponseEntity.status(HttpStatus.CREATED).body(this.userMapper.toModel(this.userService.create(user)));

	}

}
