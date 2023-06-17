package com.client.ws.rasmooplus.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.client.ws.rasmooplus.domain.repository.UserCredentialsRepository;
import com.client.ws.rasmooplus.domain.service.TokenService;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;	
	private TokenService tokenService;
	private UserCredentialsRepository userCredentialsRepository;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	
	//configurar de autenticação -> login e senha
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	// configurar de autorização -> acessos url's
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers(  "/subscriptionType").permitAll()
		.antMatchers(HttpMethod.GET ,  "/subscriptionType/*").permitAll()
		.antMatchers(HttpMethod.POST ,  "/auth").permitAll()
		.antMatchers(HttpMethod.POST ,  "/users").permitAll()
		.antMatchers(HttpMethod.POST ,  "/payment/process").permitAll()
		.antMatchers("/h2-console/**").permitAll()		
		.anyRequest().authenticated()
		.and().
		csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().headers().frameOptions().sameOrigin()		
		.and()
		.addFilterBefore(new AuthenticationFilter(tokenService , userCredentialsRepository), UsernamePasswordAuthenticationFilter.class);
		
		
		
		
	}

	
	//configurar arquivos estáticos -> imagens, css, javaScript
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	


}
