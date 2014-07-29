package org.nasdanika.examples.bank.app.tests.actors;

import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;

public interface BankActorFactory {
	
	BankPageFactory getPageFactory();
	
	Guest createGuest();		

}
