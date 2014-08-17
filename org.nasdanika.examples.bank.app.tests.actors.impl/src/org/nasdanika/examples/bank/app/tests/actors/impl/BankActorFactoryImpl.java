package org.nasdanika.examples.bank.app.tests.actors.impl;

import org.nasdanika.examples.bank.app.tests.actors.BankActorFactory;
import org.nasdanika.examples.bank.app.tests.actors.Customer;
import org.nasdanika.examples.bank.app.tests.actors.Guest;
import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.webtest.AbstractNasdanikaWebTestRunner;
import org.openqa.selenium.WebDriver;

public class BankActorFactoryImpl implements BankActorFactory {

	private BankPageFactory pageFactory;

	public void setPageFactory(BankPageFactory pageFactory) {
		this.pageFactory = AbstractNasdanikaWebTestRunner.proxyPageFactory(pageFactory);
	}

	@Override
	public Guest createGuest(WebDriver webDriver) {		
		return new GuestImpl(this, webDriver);
	}

	@Override
	public BankPageFactory getPageFactory() {
		return pageFactory;
	}

	@Override
	public Customer createCustomer(WebDriver webDriver, CustomerHome customerHome) {
		return new CustomerImpl(this, webDriver, customerHome);
	}

}
