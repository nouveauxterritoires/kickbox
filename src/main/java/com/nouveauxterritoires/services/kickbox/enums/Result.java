package com.nouveauxterritoires.services.kickbox.enums;

import lombok.Getter;

/**
 * @author szagriichuk, jredondo.
 * @date 20220211
 */
public enum Result {
	
    DELIVERABLE("deliverable"), 
    UNDELIVERABLE("undeliverable"), 
    RISKY("risky"), 
    UNKNOWN("unknown");

	@Getter
    private String value;

    Result(String value) {
        this.value = value;
    }

}
