package service;

public class FechaServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4701113043166297875L;

	public FechaServiceException() {
	}

	public FechaServiceException(String message) {
		super(message);

	}

	public FechaServiceException(Throwable cause) {
		super(cause);

	}

	public FechaServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public FechaServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
