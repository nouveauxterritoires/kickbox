package com.nouveauxterritoires.services.kickbox;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nouveauxterritoires.services.kickbox.enums.Result;
import com.nouveauxterritoires.services.kickbox.http.params.Email;
import com.nouveauxterritoires.services.kickbox.http.params.Timeout;
import com.nouveauxterritoires.services.kickbox.http.url.Url;
import com.nouveauxterritoires.services.kickbox.model.ExtendedKickBoxResponse;
import com.nouveauxterritoires.services.kickbox.model.KickBoxResponse;

/**
 * The Java API for the <a href="http://docs.kickbox.io/docs/using-the-api">Kickbox.io</a> service.
 * Can be used for easy verification of the emails in the java projects.
 *
 * The Response
 *
 * A successful API call response looks like this:
 *
 *{
 * "result":"undeliverable",
 * "reason":"rejected_email",
 * "role":false,
 * "free":false,
 * "disposable":false,
 * "accept_all":false,
 * "did_you_mean":"bill.lumbergh@gmail.com",
 * "sendex":0.23,
 * "email":"bill.lumbergh@gamil.com",
 * "user":"bill.lumbergh",
 *  "domain":"gamil.com",
 * "success":true,
 * "message":null
 *}

 *   • result string - The verification result: 
 *   	• deliverable
 *   	• undeliverable
 *   	• risky
 *   	• unknown
 *   • reason string - The reason for the result. Possible reasons are:
 *      • invalid_email - Specified email is not a valid email address syntax
 *      • invalid_domain - Domain for email does not exist
 *      • rejected_email - Email address was rejected by the SMTP server, email address does not exist
 *      • accepted_email - Email address was accepted by the SMTP server
 *      • low_quality - Email address has quality issues that may make it a risky or low-value address
 *      • low_deliverability - Email address appears to be deliverable, but deliverability cannot be guaranteed
 *      • no_connect - Could not connect to SMTP server
 *      • timeout - SMTP session timed out
 *      • invalid_smtp - SMTP server returned an unexpected/invalid response
 *      • unavailable_smtp - SMTP server was unavailable to process our request
 *      • unexpected_error - An unexpected error has occurred
 *   • role true | false - true if the email address is a role address (postmaster@example.com, support@example.com, etc)
 *   • free true | false - true if the email address uses a free email service like gmail.com or yahoo.com.
 *   • disposable true | false - true if the email address uses a disposable domain like trashmail.com or mailinator.com.
 *   • accept_all true | false - true if the email was accepted, but the domain appears to accept all emails addressed to that domain.
 *   • did_you_mean null | string - Returns a suggested email if a possible spelling error was detected. (bill.lumbergh@gamil.com -> bill.lumbergh@gmail.com)
 *   • sendex float - A quality score of the provided email address ranging between 0 (no quality) and 1 (perfect quality). More information on the Sendex Score can be found here.
 *   • email string - Returns a normalized version of the provided email address. (BoB@example.com -> bob@example.com)
 *   • user string - The user (a.k.a local part) of the provided email address. (bob@example.com -> bob)
 *   • domain string - The domain of the provided email address. (bob@example.com -> example.com)
 *   • success true | false - true if the API request was successful (i.e., no authentication or unexpected errors occurred)
 *
 *
 * @author szagriichuk, jredondo.
 * @date 20220211
 */
public class KickBoxApi extends BaseHttpApi {
	
	// Initialize Logger
	public transient static Logger logger = LogManager.getLogger(KickBoxApi.class);

    public KickBoxApi(String key) {
        super(key);
    }

    /**
     * Verifies the input {@code email} and returns {@code true} if email is valid
	 * and deliverable in other case
     * returns {@code false}.
     */
    public boolean verify(String email) {
        return verify(email, null);

    }

    /**
     * Verifies the input {@code email} and returns {@code true} if email is valid 
     * and deliverable in other case
     * returns {@code false}.
     * <p>
     * The {@code timeout} is maximum time, in milliseconds, for the API to complete 
     * a verification request.
     * If it is {@code null} will be used default value is 6000 ms.
     */
    public boolean verify(String email, Long timeout) {
        ExtendedKickBoxResponse response = verifyWithResponse(email, timeout);
        logger.debug("response : " + response.toString());
        return Result.DELIVERABLE.getValue().equals(response.getKickboxResponse().getResult());
    }

    /**
     * Verifies the input {@code email} and returns new instance of {@link ExtendedKickBoxResponse} which contains
     * full description of the verification.
     */
    public ExtendedKickBoxResponse verifyWithResponse(String email) {
        return verifyWithResponse(email, null);
    }


    /**
     * Verifies the input {@code email} and returns {@code true} if email is valid and deliverable in other case
     * returns {@code false}.
     * <p>
     * The {@code timeout} is maximum time, in milliseconds, for the API to complete a verification request.
     * If it is {@code null} will be used default value is 6000 ms.
     */
    public ExtendedKickBoxResponse verifyWithResponse(String email, Long timeout) {
        ExtendedKickBoxResponse response;
        if (timeout != null) {
            response = get(Url.verifyV2().build(), new Email(email), new Timeout(timeout));
        } else {
            response = get(Url.verifyV2().build(), new Email(email));
        }
        return response;
    }
    
    
    /**
     * Verifies the input {@code email} and returns {@code true} if email is valid and deliverable in other case
     * returns {@code false}.
     * <p>
     * The {@code timeout} is maximum time, in milliseconds, for the API to complete a verification request.
     * If it is {@code null} will be used default value is 6000 ms.
     */
    public ExtendedKickBoxResponse balance(String email, Long timeout) {
        ExtendedKickBoxResponse response;
        if (timeout != null) {
            response = get(Url.verifyV2().build(), new Email(email), new Timeout(timeout));
        } else {
            response = get(Url.verifyV2().build(), new Email(email));
        }
        return response;
    }
}
