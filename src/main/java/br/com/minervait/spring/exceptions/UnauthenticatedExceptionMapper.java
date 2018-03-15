package br.com.minervait.spring.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.minervait.spring.utils.ErrorMessage;

@Provider
public class UnauthenticatedExceptionMapper implements ExceptionMapper<UnauthenticatedException>{

	@Override
	public Response toResponse(UnauthenticatedException exception) {
		return Response.status(Response.Status.FORBIDDEN)
                .entity(ErrorMessage.builder()
                        .addErro(exception.getMessage())
                        .addStatusCode(Response.Status.FORBIDDEN.getStatusCode())
                        .addStatusMessage(Response.Status.FORBIDDEN.toString())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();
	}

}
