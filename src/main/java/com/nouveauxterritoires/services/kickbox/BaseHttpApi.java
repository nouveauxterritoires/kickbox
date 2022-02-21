package com.nouveauxterritoires.services.kickbox;

import static com.nouveauxterritoires.services.kickbox.http.HttpExecutor.execute;

import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.Header;

import com.nouveauxterritoires.services.kickbox.http.Headers;
import com.nouveauxterritoires.services.kickbox.http.HttpMethod;
import com.nouveauxterritoires.services.kickbox.http.params.ApiKey;
import com.nouveauxterritoires.services.kickbox.http.params.Param;
import com.nouveauxterritoires.services.kickbox.model.ExtendedKickBoxResponse;

/**
 * Provides common methods for
 *
 * @author szagriichuk.
 */
abstract class BaseHttpApi extends Key {

    public BaseHttpApi(String key) {
        super(key);
    }

    String createRequestString(String delim, ApiKey apiKey, Param<?>... params) {
        if (params == null || params.length == 0)
            return "";

        return createRequestParams(delim, apiKey, params);
    }

    String createRequestParams(String delim, ApiKey apiKey, Param<?>... params) {
        StringBuilder builder = new StringBuilder();
        builder.append(apiKey).append(delim);
        for (int i = 0; i < params.length - 1; i++) {
            builder.append(params[i]).append(delim);
        }
        builder.append(params[params.length - 1]);
        return builder.toString().trim();
    }

    HttpUriRequestBase createGetRequestWithHeader(String url, List<Header> headers) {
        HttpUriRequestBase requestBase = HttpMethod.GET.create(url);
        addHeaders(headers, requestBase);
        return requestBase;
    }

    private void addHeaders(List<Header> headers, HttpUriRequestBase requestBase) {
        for (Header header : headers) {
            requestBase.addHeader(header);
        }
    }

    ExtendedKickBoxResponse get(String url, Param<?>... params) {
        return get(url, Headers.create(), params);
    }

    ExtendedKickBoxResponse get(String url, List<Header> headers, Param<?>... params) {
        return execute(createGetRequestWithHeader(createUrlWithParams(url + "?", createRequestString("&", new ApiKey(key), params)), headers));
    }

    String createUrlWithParams(String url, String paramsValues) {
        return url + paramsValues;
    }
}
