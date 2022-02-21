package com.nouveauxterritoires.services.kickbox.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author szagriichuk.
 */
public enum HttpMethod {
	
	
    GET {
    	// Initialize Logger
    	public transient Logger logger = LogManager.getLogger(HttpMethod.class);

    	@Override
        public HttpUriRequestBase create(String url) {
        	logger.debug("url : " + url);
            return new HttpGet(url);
        }
    };

    public abstract HttpUriRequestBase create(String url);

}
