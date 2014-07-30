package org.nasdanika.examples.bank.app.tests.actors.impl;

import org.nasdanika.examples.bank.app.tests.actors.BankActorFactory;
import org.nasdanika.examples.bank.app.tests.actors.Customer;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Page;

class CustomerImpl implements Customer {
	
	private Page currentPage;

	CustomerImpl(BankActorFactory factory, CustomerHome homePage) {
		this.currentPage = homePage;
	}

	@Override
	public Page getCurrentPage() {
		return currentPage;
	}

	@Override
	public Actor signOut(boolean confirm) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

}
