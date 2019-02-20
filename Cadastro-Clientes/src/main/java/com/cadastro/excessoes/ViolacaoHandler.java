package com.cadastro.excessoes;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
class ViolacaoHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {

		Violacoes violacoes = new Violacoes();

		constraintViolationException.getConstraintViolations().forEach(violacoes::inserirViolacao);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(violacoes);

	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleErroInterno(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}
	
}
