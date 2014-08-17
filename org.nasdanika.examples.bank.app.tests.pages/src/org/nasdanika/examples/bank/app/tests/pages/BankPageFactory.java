package org.nasdanika.examples.bank.app.tests.pages;

import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.app.tests.pages.guest.GuestHome;
import org.openqa.selenium.WebDriver;

public interface BankPageFactory {
	
	GuestHome createGuestHome(WebDriver webDriver);

	CustomerHome createCustomerHome(WebDriver webDriver);
	
}
