package org.nasdanika.examples.bank.app.tests.pages.guest;

import org.nasdanika.webtest.Page;

public interface GuestHome extends Page {
	
	/**
	 * Navigates to the home page.
	 */
	void open();
	
	void enterOnlineId(String onlineId);
	
	void enterPassword(String password);
	
	/**
	 * Clicks sign-in button.
	 * @return Customer home if sign-in was successful, this page if input validation fails, or authentication failed dialog 
	 * if incorrect credentials were provided.
	 */
	Page clickSignIn();

	SignUpDialog clickSignUp();	

}
