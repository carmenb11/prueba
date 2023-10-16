package service;

public class RegistroServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8523287953078862912L;

	public RegistroServiceException() {
	}

	public RegistroServiceException(String message) {
		super(message);

	}

	public RegistroServiceException(Throwable cause) {
		super(cause);

	}

	public RegistroServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public RegistroServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
