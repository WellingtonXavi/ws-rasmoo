package com.client.ws.rasmooplus.domain.service.impl;

import java.util.Objects;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.domain.exception.BadRequestException;
import com.client.ws.rasmooplus.domain.exception.IntegrityViolationException;
import com.client.ws.rasmooplus.domain.exception.NotFoundException;
import com.client.ws.rasmooplus.domain.model.User;
import com.client.ws.rasmooplus.domain.model.UserType;
import com.client.ws.rasmooplus.domain.repository.UserRepository;
import com.client.ws.rasmooplus.domain.repository.UserTypeRepository;
import com.client.ws.rasmooplus.domain.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserTypeRepository userTypeRepository;
	private UserRepository userRepository;

	@Override
	public User create(User user) {

		if (Objects.nonNull(user.getId())) {
			throw new BadRequestException("O campo id não deve ser informado.");
		}

		try {

			UserType userType = this.userTypeRepository.findById(user.getUserType().getId())
					.orElseThrow(() -> new NotFoundException("User Type não encontrado"));

			user.setUserType(userType);
			return this.userRepository.save(user);

		}

		catch (DataIntegrityViolationException e) {

			throw new IntegrityViolationException(
					"Erro de integridade de dados. Os campos e-mail ou cpf já possuem cadastro em nossa base de dados.");
		}

	}

}
