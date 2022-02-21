package com.nouveauxterritoires.services.kickbox.http.params;

/**
 * @author szagriichuk.
 */
public class ApiKey extends Param<String> {
    public ApiKey(String param) {
        super(param);
    }

    @Override
    public String name() {
        return "apikey";
    }
}
