package com.client.ws.rasmooplus.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_type")
@Data
@NoArgsConstructor
public class UserType implements GrantedAuthority {
	
	
	private static final long serialVersionUID = 1L;

	@Column(name = "user_type_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;

	public UserType(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	
	

}
