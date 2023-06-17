package com.client.ws.rasmooplus.api.dto.error;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class ErrorResponseDto {
	
	
	private String message;
	private HttpStatus httpStatus;
	private Integer statusCode;
	private OffsetDateTime dataHora;
	private List<Errors> errors;

}
