package org.nasdanika.examples.bank.app.tests.pages.customer;

import org.nasdanika.webtest.Page;

/**
 * Base interface for customer pages.
 * @author Pavel Vlasov
 *
 */
public interface CustomerPage extends Page {
	
	/**
	 * Clicks sign-out link.
	 */
	CustomerPage clickSignOut();
	
	/**
	 * Clicks OK or Cancel in sign-out confirmation dialog.
	 * @param confirm
	 * @return
	 */
	Page confirmSignOut(boolean confirm);	
	
	/**
	 * @return Text in the nav-bar banner.
	 */
	String getBanner();
	

}
