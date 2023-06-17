package com.client.ws.rasmooplus.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.client.ws.rasmooplus.api.dto.error.ErrorResponseDto;
import com.client.ws.rasmooplus.api.dto.error.Errors;
import com.client.ws.rasmooplus.domain.exception.BadRequestException;
import com.client.ws.rasmooplus.domain.exception.BusinessException;
import com.client.ws.rasmooplus.domain.exception.IntegrityViolationException;
import com.client.ws.rasmooplus.domain.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class ResourceHandler {
	
	private MessageSource messageSource;

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponseDto> notFoundException(NotFoundException exception) {

		ErrorResponseDto dto = this.getErrorResponseDto(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(),
				exception.getMessage() , null);


		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponseDto> businessException(BusinessException exception) {

		ErrorResponseDto dto = this.getErrorResponseDto(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(),
				exception.getMessage() , null);


		return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponseDto> badRequestException(BadRequestException exception) {

		ErrorResponseDto dto = this.getErrorResponseDto(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
				exception.getMessage() , null);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}
	
	@ExceptionHandler(IntegrityViolationException.class)
	public ResponseEntity<ErrorResponseDto> IntegrityViolationException(IntegrityViolationException exception) {

		ErrorResponseDto dto = this.getErrorResponseDto(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
				exception.getMessage() , null);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		List<Errors> errors = new ArrayList<>();
		
		for (ObjectError objectError : exception.getBindingResult().getAllErrors()) {
			
			String field = ( ( FieldError ) objectError ).getField();
			String message = this.messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
			errors.add(new Errors(field, message));
			
		}
		
		ErrorResponseDto dto = this.getErrorResponseDto(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
				"Existem campos com erro(s)." , errors);
		
	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
		
	}
	
	
	
	
	
	
	
	

	private ErrorResponseDto getErrorResponseDto(HttpStatus httpStatus, Integer satusCode, String message, List<Errors> errors) {
		ErrorResponseDto dto = new ErrorResponseDto();
		dto.setDataHora(OffsetDateTime.now());
		dto.setHttpStatus(httpStatus);
		dto.setMessage(message);
		dto.setStatusCode(satusCode);
		dto.setErrors(errors);
		return dto;
	}

}
