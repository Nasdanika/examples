package org.nasdanika.examples.bank.app.tests.actors.impl;

import org.nasdanika.examples.bank.app.tests.actors.BankActorFactory;
import org.nasdanika.examples.bank.app.tests.actors.Customer;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerPage;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

class CustomerImpl implements Customer {
	
	private Page currentPage;
	private WebDriver webDriver;
	private BankActorFactory factory;

	CustomerImpl(BankActorFactory factory, WebDriver webDriver, CustomerHome homePage) {
		this.factory = factory;
		this.currentPage = homePage;
		this.webDriver = webDriver;
	}

	@Override
	public Page getCurrentPage() {
		return currentPage;
	}

	@Override
	public Actor signOut(boolean confirm) {
		CustomerPage customerPage = (CustomerPage) currentPage;
		customerPage.clickSignOut();
		Page page = customerPage.confirmSignOut(confirm);
		if (page instanceof CustomerPage) {
			currentPage = page;
			return this;
		}
		
		return factory.createGuest(webDriver); // Should have gone to the guest home.
	}
	

}
