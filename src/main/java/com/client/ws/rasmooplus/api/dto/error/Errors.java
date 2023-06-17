package com.client.ws.rasmooplus.api.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Errors {
	
	
	private String field;
	private String message;
	
	

}
