package service;

public class UsuarioServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5071463013446853372L;

	public UsuarioServiceException() {
	}

	public UsuarioServiceException(String message) {
		super(message);

	}

	public UsuarioServiceException(Throwable cause) {
		super(cause);

	}

	public UsuarioServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public UsuarioServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
