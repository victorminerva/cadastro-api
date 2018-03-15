package br.com.minervait.spring.exceptions;

public class UnauthenticatedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnauthenticatedException(String s) {
		super(s);
	}

}