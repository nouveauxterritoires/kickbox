package com.nouveauxterritoires.services.kickbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author szagriichuk, jredondo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ExtendedKickBoxResponse {
	
	private String message;
	private int code;
    private KickBoxResponse kickboxResponse;


    @Override
    public String toString() {
        return "ExtendedKickBoxResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", kickboxResponse=" + kickboxResponse +
                "} " + super.toString();
    }
}
