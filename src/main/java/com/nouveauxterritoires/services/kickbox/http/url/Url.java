package com.nouveauxterritoires.services.kickbox.http.url;

import java.util.ArrayList;
import java.util.List;

import com.nouveauxterritoires.services.kickbox.enums.Uris;


/**
 * Url builder. Added for simplify creating different urls.
 *
 * @author szagriichuk.
 */
public final class Url {
    private List<Uris> uris = new ArrayList<>();

    private Url() {
    }

    public static Url start() {
        return new Url();
    }

    public static Url verifyV2() {
        return Url.start().of(Uris.API).of(Uris.V2).of(Uris.VERIFY);
    }
    
    public static Url balanceV2() {
        return Url.start().of(Uris.API).of(Uris.V2).of(Uris.BALANCE);
    }

    public Url of(Uris uri) {
        uris.add(uri);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < uris.size() - 1; i++) {
            addParameter(builder, uris.get(i));
        }
        addLastParameter(builder, uris.get(uris.size() - 1));

        return builder.toString();
    }

    private void addParameter(StringBuilder builder, Uris uri) {
        builder.append(uri).append("/");
    }

    private void addLastParameter(StringBuilder builder, Uris uri) {
        builder.append(uri);
    }
}
