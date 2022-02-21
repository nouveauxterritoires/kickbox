package com.nouveauxterritoires.services.kickbox.http.params;

/**
 * @author szagriichuk.
 */
public class Email extends Param<String> {
    public Email(String param) {
        super(param);
    }

    @Override
    public String name() {
        return "email";
    }
}
