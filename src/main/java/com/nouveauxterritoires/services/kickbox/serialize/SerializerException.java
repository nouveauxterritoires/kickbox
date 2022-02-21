package com.nouveauxterritoires.services.kickbox.serialize;

/**
 * @author szagriichuk.
 */
public class SerializerException extends RuntimeException {
	
    private static final long serialVersionUID = -5595107517490179653L;

	public SerializerException(String message) {
        super(message);
    }

    public SerializerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializerException(Throwable cause) {
        super(cause);
    }

    public SerializerException(String message, Throwable cause, 
    		boolean enableSuppression, boolean writableStackTrace) {
    	
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
