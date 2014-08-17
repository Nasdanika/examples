package org.nasdanika.examples.bank.app.tests.actors;

import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.openqa.selenium.WebDriver;

public interface BankActorFactory {
	
	BankPageFactory getPageFactory();
	
	Guest createGuest(WebDriver webDriver);

	Customer createCustomer(WebDriver webDriver, CustomerHome customerHome);		

}
