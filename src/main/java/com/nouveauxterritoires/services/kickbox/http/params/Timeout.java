package com.nouveauxterritoires.services.kickbox.http.params;

/**
 * @author szagriichuk.
 */
public class Timeout extends Param<Long> {
    public Timeout(Long param) {
        super(param);
    }

    @Override
    public String name() {
        return "timeout";
    }
}
