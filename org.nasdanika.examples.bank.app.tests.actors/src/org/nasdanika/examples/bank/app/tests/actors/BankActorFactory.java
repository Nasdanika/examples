package org.nasdanika.examples.bank.app.tests.actors;

import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.webtest.Actor;

public interface BankActorFactory {
	
	BankPageFactory getPageFactory();
	
	Guest createGuest();

	Customer createCustomer(CustomerHome customerHome);		

}
