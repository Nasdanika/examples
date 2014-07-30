package org.nasdanika.examples.bank.app.tests.pages;

import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.app.tests.pages.guest.GuestHome;

public interface BankPageFactory {
	
	GuestHome createGuestHome();

	CustomerHome createCustomerHome();
	
}
