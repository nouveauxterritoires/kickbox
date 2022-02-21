package com.nouveauxterritoires.services.kickbox.http;

import com.nouveauxterritoires.services.kickbox.http.params.Param;

import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.message.BasicHeader;

/**
 * @author szagriichuk.
 */
public class Headers {
	
    public static List<Header> create(Param<?>... params) {
        List<Header> headers = new ArrayList<>();
        if (params != null) {
            for (Param<?> param : params) {
                headers.add(new BasicHeader(param.name(), String.valueOf(param.value())));
            }
        }
        return headers;
    }
}
