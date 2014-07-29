package org.nasdanika.examples.bank.app.tests.actors.impl;

import org.junit.Assert;
import org.nasdanika.examples.bank.app.tests.actors.BankActorFactory;
import org.nasdanika.examples.bank.app.tests.actors.Guest;
import org.nasdanika.examples.bank.app.tests.pages.guest.Home;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Description;
import org.nasdanika.webtest.Page;

class GuestImpl implements Guest {

	private BankActorFactory factory;
	private Page currentPage;

	GuestImpl(BankActorFactory factory) {
		this.factory = factory;
	}

	@Override
	public Page getCurrentPage() {
		return currentPage;
	}

	@Override
	public Actor signIn(String onlineId, String password) {
		Home home = factory.getPageFactory().createGuestHomePage();
		home.open();
		Assert.assertTrue("Navigation to home page failed", home.match());
		home.enterOnlineId(onlineId);
		home.enterPassword(password);
		currentPage = home.clickSignIn();
		// TODO match the page to the customer home and return a new customer if match returns true.
		return null;
	}

}
