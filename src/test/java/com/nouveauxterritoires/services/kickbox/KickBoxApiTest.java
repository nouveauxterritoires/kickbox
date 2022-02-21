package com.nouveauxterritoires.services.kickbox;

import java.util.ResourceBundle;

public interface KickBoxApiTest {

	// The sandbox API_KEY
	// starts with test_
	public final String API_KEY_SANDBOX = ResourceBundle.getBundle("kickbox").getString("api.key.sandbox");
		
}
