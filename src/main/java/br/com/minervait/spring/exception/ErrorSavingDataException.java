package br.com.minervait.spring.exception;

public class ErrorSavingDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErrorSavingDataException(String message) {
		super(message);
	}

}
