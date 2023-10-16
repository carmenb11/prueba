package ejercicio01.services;

public class PeliculaServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PeliculaServiceException() {
	}

	public PeliculaServiceException(String message) {
		super(message);

	}

	public PeliculaServiceException(Throwable cause) {
		super(cause);

	}

	public PeliculaServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public PeliculaServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
