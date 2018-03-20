package br.com.minervait.spring.controller.pessoacontroller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(assignableTypes = { PessoaController.class })
public class PessoaControllerAdvice extends ResponseEntityExceptionHandler {


}
