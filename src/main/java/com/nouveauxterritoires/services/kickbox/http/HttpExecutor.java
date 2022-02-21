package com.nouveauxterritoires.services.kickbox.http;

import static com.nouveauxterritoires.services.kickbox.serialize.Serializer.deserialize;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nouveauxterritoires.services.kickbox.model.ExtendedKickBoxResponse;
import com.nouveauxterritoires.services.kickbox.model.KickBoxResponse;

/**
 * Http method executor.
 *
 * @author szagriichuk.
 */
public final class HttpExecutor {
    
	private static CloseableHttpClient httpClient = HttpClients.createDefault();

	// Initialize Logger
	public static Logger logger = LogManager.getLogger(HttpExecutor.class);

    public static ExtendedKickBoxResponse execute(HttpUriRequestBase method) {
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(method);
            String entityResponse = entityToString(response);
            logger.debug("response : " + entityResponse);
            return assignCode(deserialize(entityResponse, KickBoxResponse.class), response);
        } catch (final IOException e) {
            return new ExtendedKickBoxResponse() {{
                setMessage(e.getMessage());
                setCode(HttpStatus.SC_NOT_FOUND);
            }};
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                // do nothing
            }
        }
    }

    private static ExtendedKickBoxResponse assignCode(KickBoxResponse kickboxResponse, 
    		HttpResponse response) {
    	
    	ExtendedKickBoxResponse extendedKickboxResponse = new ExtendedKickBoxResponse();
    	
    	extendedKickboxResponse.setCode(response.getCode());
    	extendedKickboxResponse.setKickboxResponse(kickboxResponse);
    	
        return extendedKickboxResponse;
    }

    private static String entityToString(CloseableHttpResponse response) {
        try {
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            throw new HttpException(e.getMessage());
        }
    }
}
