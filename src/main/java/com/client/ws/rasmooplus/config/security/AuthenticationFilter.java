package com.client.ws.rasmooplus.config.security;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.client.ws.rasmooplus.domain.exception.NotFoundException;
import com.client.ws.rasmooplus.domain.model.UserCredentials;
import com.client.ws.rasmooplus.domain.repository.UserCredentialsRepository;
import com.client.ws.rasmooplus.domain.service.TokenService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

	private TokenService tokenService;

	private UserCredentialsRepository userCredentialsRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = getToken(request);

		boolean tokenValid = this.tokenService.isValid(token);

		if (tokenValid) {
			authByToken(token);
		}

		filterChain.doFilter(request, response);
	}

	private void authByToken(String token) {
		// recuperar id do usuario

		Long id = tokenService.getUserId(token);

		UserCredentials userCredentials = this.userCredentialsRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Usuário não localizado"));

		// autenticar

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userCredentials,
				null, userCredentials.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

	private String getToken(HttpServletRequest request) {

		String token = request.getHeader("Authorization");

		if (Objects.isNull(token) || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}

		return token.substring(7, token.length());
	}

}
