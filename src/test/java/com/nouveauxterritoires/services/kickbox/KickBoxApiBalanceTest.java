package com.nouveauxterritoires.services.kickbox;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.nouveauxterritoires.services.kickbox.model.ExtendedKickBoxResponse;

/**
 * @author szagriichuk.
 */
public class KickBoxApiBalanceTest  implements KickBoxApiTest {

	// Initialize Logger
	public static Logger logger = LogManager.getLogger(KickBoxApiBalanceTest.class);

	private final KickBoxApi kickBoxApiSanbox = new KickBoxApi(API_KEY_SANDBOX);
	private final KickBoxApi kickBoxApiLive = new KickBoxApi(API_KEY_LIVE);

	
	
	// Insufficient balance results
	@Test
    public void testVerifyInsufficientBalanceError1() throws Exception {
        boolean response = kickBoxApiSanbox.verify("insufficient-balance@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyInsufficientBalanceError2() throws Exception {
        boolean response = kickBoxApiSanbox.verify("henry+insufficient-balance@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Insufficient balance results with response
	@Test
    public void testVerifyInsufficientBalanceErrorResponse() throws Exception {
		ExtendedKickBoxResponse kickBoxResponse = kickBoxApiSanbox.verifyWithResponse("henry+insufficient-balance@example.com");
    	logger.debug("kickBoxResponse : " + kickBoxResponse.getKickboxResponse().toString());
        
        assertFalse(kickBoxResponse.getKickboxResponse().isSuccess());
        assertTrue("Insufficient balance".equals(kickBoxResponse.getKickboxResponse().getMessage()));

    }
    
	// Insufficient balance results with response
	@Test
    public void testVerifyBalanceResponse() throws Exception {
		ExtendedKickBoxResponse kickBoxResponse = kickBoxApiLive.balance();
    	logger.debug("kickBoxResponse : " + kickBoxResponse.getKickboxResponse().toString());
        
        assertTrue(kickBoxResponse.getKickboxResponse().isSuccess());
        assert(kickBoxResponse.getKickboxResponse().getBalance() >= 0);

    }
	    
}