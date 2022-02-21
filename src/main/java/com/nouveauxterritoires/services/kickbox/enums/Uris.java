package com.nouveauxterritoires.services.kickbox.enums;

import lombok.Getter;

/**
 * Uris of the kickbox api.
 *
 * @author szagriichuk.
 */
public enum Uris {
	
    API("https://api.kickbox.io"), 
    VERIFY("verify"), 
    BALANCE("balance"), 
    V2("v2");

	@Getter
    private String value;

    Uris(String value) {
        this.value = value;
    }

	@Override
	public String toString() {
		return getValue();
	}
    
    

}
