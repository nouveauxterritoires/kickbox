package com.nouveauxterritoires.services.kickbox.enums;

import lombok.Getter;

public enum Reason {

	INVALID_EMAIL("invalid_email"),
	INVALID_DOMAIN("invalid_domain"),
	REJECTED_EMAIL("rejected_email"), 
	ACCEPTED_EMAIL("accepted_email"), 
	LOW_QUALITY("low_quality"),
	LOW_DELIVERABILITY("low_deliverability"),
	NO_CONNECT("no_connect"),
	TIMEOUT("timeout"),
    INVALID_SMTP("invalid_smtp"),
    UNAVAILABLE_SMTP("unavailable_smtp"),
	UNEXPECTED_ERROR("unexpected_error");
    
	@Getter
    private String value;

    Reason(String value) {
        this.value = value;
    }

}
