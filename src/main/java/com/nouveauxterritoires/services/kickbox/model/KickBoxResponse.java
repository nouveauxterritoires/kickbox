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
public class KickBoxResponse {
	
    private String result;
    private String reason;
    private boolean role;
    private boolean free;
    private boolean disposable;
    private boolean accept_all;
    private String did_you_mean;
    private double sendex;
    private String email;
    private String user;
    private String domain;
    private boolean success;
    private String message;

    @Override
    public String toString() {
        return "KickBoxResponse{" +
                "result='" + result + '\'' +
                ", reason='" + reason + '\'' +
                ", role=" + role +
                ", free=" + free +
                ", disposable=" + disposable +
                ", accept_all=" + accept_all +
                ", did_you_mean='" + did_you_mean + '\'' +
                ", sendex=" + sendex +
                ", email='" + email + '\'' +
                ", user='" + user + '\'' +
                ", domain='" + domain + '\'' +
                ", success=" + success +
                ", message=" + message +
                '}';
    }
}
