package com.nouveauxterritoires.services.kickbox;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.nouveauxterritoires.services.kickbox.enums.Reason;
import com.nouveauxterritoires.services.kickbox.enums.Result;
import com.nouveauxterritoires.services.kickbox.model.ExtendedKickBoxResponse;

/**
 * @author szagriichuk.
 */
public class KickBoxApiEmailTest implements KickBoxApiTest {

	// Initialize Logger
	public static Logger logger = LogManager.getLogger(KickBoxApiEmailTest.class);

	private final KickBoxApi kickBoxApi = new KickBoxApi(API_KEY_SANDBOX);

	
	// Valid email results
	@Test
    public void testVerifyValidEmail1() throws Exception {
        boolean response = kickBoxApi.verify("deliverable@example.com");
        logger.debug("response : " + response);
        assertTrue(response);
    }
	
	@Test
    public void testVerifyValidEmail2() throws Exception {
        boolean response = kickBoxApi.verify("john+deliverable@example.com");
        logger.debug("response : " + response);
        assertTrue(response);
    }
	
	// Valid email results with response
	@Test
    public void testVerifyValidEmailResponse() throws Exception {
    	ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("john+deliverable@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.ACCEPTED_EMAIL.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.DELIVERABLE.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("john+deliverable@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("john+deliverable".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
	
	
	// Undeliverable results
	@Test
    public void testVerifyUndeliverableEmail1() throws Exception {
        boolean response = kickBoxApi.verify("rejected-email@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyUndeliverableEmail2() throws Exception {
        boolean response = kickBoxApi.verify("art+rejected-email@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Undeliverable results with response
	@Test
    public void testVerifyUndeliverableEmailResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("art+rejected-email@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.REJECTED_EMAIL.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.UNDELIVERABLE.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("art+rejected-email@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("art+rejected-email".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));    }
	
	
	
	// Invalid domain results
	@Test
    public void testVerifyInvalidDomain1() throws Exception {
        boolean response = kickBoxApi.verify("invalid-domain@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }

	@Test
    public void testVerifyInvalidDomain2() throws Exception {
        boolean response = kickBoxApi.verify("mike+invalid-domain@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Invalid domain results with response
	@Test
    public void testVerifyInvalidEmailDomain() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("mike+invalid-domain@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.INVALID_DOMAIN.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.UNDELIVERABLE.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("mike+invalid-domain@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("mike+invalid-domain".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
	
	
	
	// Invalid email results
	@Test
    public void testVerifyInvalidEmail1() throws Exception {
        boolean response = kickBoxApi.verify("invalid-email@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyInvalidEmail2() throws Exception {
        boolean response = kickBoxApi.verify("mike+invalid-email@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Invalid email results with response
	@Test
    public void testVerifyInvalidEmailResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("mike+invalid-email@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.INVALID_EMAIL.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.UNDELIVERABLE.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("mike+invalid-email@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("mike+invalid-email".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
	
	
	// Invalid smtp results
	@Test
    public void testVerifyInvalidSmtp1() throws Exception {
        boolean response = kickBoxApi.verify("invalid-smtp@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyInvalidSmtp2() throws Exception {
        boolean response = kickBoxApi.verify("bill+invalid-smtp@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Invalid smtp results with response
	@Test
    public void testVerifyInvalidSmtpResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("bill+invalid-smtp@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.INVALID_SMTP.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.UNDELIVERABLE.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("bill+invalid-smtp@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("bill+invalid-smtp".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
	
	
	// Risky results
	
	// Low quality results
	@Test
    public void testVerifyLowQuality1() throws Exception {
        boolean response = kickBoxApi.verify("low-quality@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyLowQuality2() throws Exception {
        boolean response = kickBoxApi.verify("jane+low-quality@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Low quality results with response
	@Test
    public void testVerifyLowQualityResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("jane+low-quality@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.LOW_QUALITY.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.RISKY.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("jane+low-quality@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("jane+low-quality".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() >= 0.0d);
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() <= 1.0d);
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
	
	
	// Accep all results
	@Test
    public void testVerifyAcceptAll1() throws Exception {
        boolean response = kickBoxApi.verify("accept-all@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyAcceptAll2() throws Exception {
        boolean response = kickBoxApi.verify("oscar+accept-all@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Accep all results with response
	@Test
    public void testVerifyAcceptAllResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("oscar+accept-all@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.LOW_DELIVERABILITY.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.RISKY.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("oscar+accept-all@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("oscar+accept-all".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() >= 0.0d);
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() <= 1.0d);
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
		
		
	// Role results
	@Test
    public void testVerifyRole1() throws Exception {
        boolean response = kickBoxApi.verify("role@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyRole2() throws Exception {
        boolean response = kickBoxApi.verify("jenny+role@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Role results with response
	@Test
    public void testVerifyRoleResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("jenny+role@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.LOW_QUALITY.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.RISKY.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("jenny+role@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("jenny+role".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() >= 0.0d);
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() <= 1.0d);
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
	}
	
	
	// Disposable results
	@Test
    public void testVerifyDisposable1() throws Exception {
        boolean response = kickBoxApi.verify("disposable@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyDisposable2() throws Exception {
        boolean response = kickBoxApi.verify("paul+disposable@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Disposable results with response
	@Test
    public void testVerifyDisposableResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("paul+disposable@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.LOW_QUALITY.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.RISKY.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("paul+disposable@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("paul+disposable".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() == 0.0d);
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
		
	
	// Unknow results
	
	// Timeout results
	@Test
    public void testVerifyTimeout1() throws Exception {
        boolean response = kickBoxApi.verify("timeout@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyTimeout2() throws Exception {
        boolean response = kickBoxApi.verify("sarah+timeout@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Timeout results with response
	@Test
    public void testVerifyTimeoutResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("sarah+timeout@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.TIMEOUT.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.UNKNOWN.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("sarah+timeout@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("sarah+timeout".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() == 0.0d);
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
	
	// Unexpected error results
	@Test
    public void testVerifyUnexpectedError1() throws Exception {
        boolean response = kickBoxApi.verify("unexpected-error@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyUnexpectedError2() throws Exception {
        boolean response = kickBoxApi.verify("sarah+unexpected-error@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Unexpected error results with response
	@Test
    public void testVerifyUnexpectedErrorResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("sarah+unexpected-error@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.UNEXPECTED_ERROR.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.UNKNOWN.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("sarah+unexpected-error@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("sarah+unexpected-error".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() == 0.0d);
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
	
	
	// No connect results
	@Test
    public void testVerifyNoConnectError1() throws Exception {
        boolean response = kickBoxApi.verify("no-connect@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyNoConnectError2() throws Exception {
        boolean response = kickBoxApi.verify("franck+no-connect@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// No connect results with response
	@Test
    public void testVerifyNoConnectErrorResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("franck+no-connect@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.NO_CONNECT.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.UNKNOWN.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("franck+no-connect@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("franck+no-connect".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() == 0.0d);
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
	
	
	// Unavailable smtp results
	@Test
    public void testVerifyUnavaibleSmtpError1() throws Exception {
        boolean response = kickBoxApi.verify("unavailable-smtp@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	@Test
    public void testVerifyUnavaibleSmtpError2() throws Exception {
        boolean response = kickBoxApi.verify("donna+unavailable-smtp@example.com");
        logger.debug("response : " + response);
        assertFalse(response);
    }
	
	// Unavailable smtp results with response
	@Test
    public void testVerifyUnavaibleSmtpErrorResponse() throws Exception {
		ExtendedKickBoxResponse extendedKickBoxResponse = kickBoxApi.verifyWithResponse("donna+unavailable-smtp@example.com");
    	logger.debug("extendedKickBoxResponse : " + extendedKickBoxResponse.getKickboxResponse().toString());
        
    	assertTrue(Reason.UNAVAILABLE_SMTP.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getReason()));
        assertTrue(Result.UNKNOWN.getValue().equals(extendedKickBoxResponse.getKickboxResponse().getResult()));
        assertTrue("donna+unavailable-smtp@example.com".equals(extendedKickBoxResponse.getKickboxResponse().getEmail()));
        assertTrue("donna+unavailable-smtp".equals(extendedKickBoxResponse.getKickboxResponse().getUser()));
        assertTrue("example.com".equals(extendedKickBoxResponse.getKickboxResponse().getDomain()));
        assertTrue(extendedKickBoxResponse.getKickboxResponse().isSuccess());
        assertTrue(extendedKickBoxResponse.getKickboxResponse().getSendex() == 0.0d);
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isRole());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isDisposable());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isAccept_all());
        assertFalse(extendedKickBoxResponse.getKickboxResponse().isFree());
        assertTrue("You are using Kickbox's sandbox API, which is used to test your integration against mock results.".equals(extendedKickBoxResponse.getKickboxResponse().getMessage()));
    }
    
    
}