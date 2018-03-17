package br.com.minervait.spring.controller.usuariocontroller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.minervait.spring.exception.EmailExistsException;
import br.com.minervait.spring.exception.ErrorSavingDataException;
import br.com.minervait.spring.model.ErrorMessage;

@ControllerAdvice
public class UsuarioControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ErrorSavingDataException.class })
	protected ResponseEntity<?> saveError(RuntimeException ex, WebRequest request) {
		final ErrorMessage error = ErrorMessage.builder()
				.addErro(ex.getMessage())
				.addStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.addStatusMessage(HttpStatus.INTERNAL_SERVER_ERROR.name())
				.build();
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(value = { EmailExistsException.class })
	protected ResponseEntity<?> emailExists(RuntimeException ex, WebRequest request) {
		final ErrorMessage error = ErrorMessage.builder()
				.addErro(ex.getMessage())
				.addStatusCode(HttpStatus.CONFLICT.value())
				.addStatusMessage(HttpStatus.CONFLICT.name())
				.build();

		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

}
