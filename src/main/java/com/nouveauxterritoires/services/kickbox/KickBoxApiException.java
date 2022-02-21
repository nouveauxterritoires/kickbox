package com.nouveauxterritoires.services.kickbox;

/**
 * @author szagriichuk.
 */
public class KickBoxApiException extends RuntimeException {
	
	private static final long serialVersionUID = -5435100850828254387L;

	public KickBoxApiException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
