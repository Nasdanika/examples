package org.nasdanika.examples.bank.app.tests.pages.guest;

import org.nasdanika.webtest.Page;

/**
 * New customer sign-up dialog.
 * @author Pavel Vlasov
 *
 */
public interface SignUpDialog extends Page {

	SignUpDialog waitToAppear();

	SignUpDialog enterOnlineId(String onlineId);

	SignUpDialog enterName(String name);

	SignUpDialog enterPassword(String password);

	SignUpDialog enterPasswordConfirmation(String passwordConfirmation);

	Page clickSignUp();
	
	GuestHome clickCancel();

	String getErrorMessage();

}
