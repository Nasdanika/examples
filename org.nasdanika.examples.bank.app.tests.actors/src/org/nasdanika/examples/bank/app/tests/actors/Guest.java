package org.nasdanika.examples.bank.app.tests.actors;

import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Description;

@Description("Unauthenticated user")
public interface Guest extends Actor {
	
	/**
	 * 
	 * @param user
	 * @param password
	 * @return Actor for the authenticated user (Customer) if log-in succesful, 
	 * self otherwise.
	 */
	@Description("Enter Online ID and Password and click 'Sign in' button.")
	Actor signIn(String onlineId, String password);

}
