package org.nasdanika.examples.bank.app.tests.actors;

import org.nasdanika.examples.bank.app.tests.pages.guest.GuestHome;
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

	/**
	 * Registers new customer.
	 * @param onlineId
	 * @param name
	 * @param password
	 * @param passwordConfirmation
	 * @return Customer if sign-up successful, Guest otherwise.
	 */
	Actor signUp(String onlineId, String name, String password, String passwordConfirmation);

	GuestHome goHome();

}
