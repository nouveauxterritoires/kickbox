package com.nouveauxterritoires.services.kickbox.enums;

import lombok.Getter;

/**
 * @author szagriichuk, jredondo.
 */
public enum Result {
	
    DELIVERABLE("DELIVERABLE"), 
    UNDELIVERABLE("UNDELIVERABLE"), 
    RISKY("RISKY"), 
    UNKNOWN("UNKNOWN");

	@Getter
    private String value;

    Result(String value) {
        this.value = value;
    }

}
