package com.nouveauxterritoires.services.kickbox.enums;

import lombok.Getter;

public enum Reason {

	INVALID_EMAIL("INVALID_EMAIL"),
	INVALID_DOMAIN("INVALID_DOMAIN"),
	REJECTED_EMAIL("REJECTED_EMAIL"), 
	ACCEPTED_EMAIL("ACCEPTED_EMAIL"), 
	LOW_QUALITY("LOW_QUALITY"),
	LOW_DELIVERABILITY("LOW_DELIVERABILITY"),
	NO_CONNECT("NO_CONNECT"),
	TIMEOUT("TIMEOUT"),
    INVALID_SMTP("INVALID_SMTP"),
    UNAVAILABLE_SMTP("UNAVAILABLE_SMTP"),
	UNEXPECTED_ERROR("UNEXPECTED_ERROR");
    
	@Getter
    private String value;

    Reason(String value) {
        this.value = value;
    }

}
