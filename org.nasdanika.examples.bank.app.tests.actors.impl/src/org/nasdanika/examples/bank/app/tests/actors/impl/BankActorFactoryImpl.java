package org.nasdanika.examples.bank.app.tests.actors.impl;

import org.nasdanika.examples.bank.app.tests.actors.BankActorFactory;
import org.nasdanika.examples.bank.app.tests.actors.Customer;
import org.nasdanika.examples.bank.app.tests.actors.Guest;
import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;

public class BankActorFactoryImpl implements BankActorFactory {

	private BankPageFactory pageFactory;

	public BankActorFactoryImpl(BankPageFactory pageFactory) {
		this.pageFactory = pageFactory;
	}

	@Override
	public Guest createGuest() {		
		return new GuestImpl(this);
	}

	@Override
	public BankPageFactory getPageFactory() {
		return pageFactory;
	}

	@Override
	public Customer createCustomer(CustomerHome customerHome) {
		return new CustomerImpl(this, customerHome);
	}

}
