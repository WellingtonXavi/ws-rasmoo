package com.client.ws.rasmooplus.domain.enums;

import lombok.Getter;

@Getter
public enum UserTypeEnum {
	
	
	
	PROFESSOR(1l),
	ADMINISTRADOR(2l),
    ALUNO(3l);
    
    private Long id;
	
	private UserTypeEnum(Long id) {
		this.id = id;
	}
	
	

}
