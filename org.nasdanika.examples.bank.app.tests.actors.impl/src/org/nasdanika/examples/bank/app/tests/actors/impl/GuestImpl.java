package org.nasdanika.examples.bank.app.tests.actors.impl;

import org.junit.Assert;
import org.nasdanika.examples.bank.app.tests.actors.BankActorFactory;
import org.nasdanika.examples.bank.app.tests.actors.Guest;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.app.tests.pages.guest.GuestHome;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Description;
import org.nasdanika.webtest.Page;
import org.openqa.selenium.NotFoundException;

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
		GuestHome home = factory.getPageFactory().createGuestHome();
		home.open();
		home.enterOnlineId(onlineId);
		home.enterPassword(password);
		currentPage = home.clickSignIn();
		// TODO match the page to the customer home and return a new customer if match returns true.
		return null;
	}

	@Override
	public Actor signUp(
			String onlineId, 
			String name, 
			String password,
			String passwordConfirmation) {
		GuestHome home = factory.getPageFactory().createGuestHome();
		home.open();
		currentPage = home;
		Page signUpResult = home.clickSignUp()
				.waitToAppear()
				.enterOnlineId(onlineId)
				.enterName(name)
				.enterPassword(password)
				.enterPasswordConfirmation(passwordConfirmation)
				.clickSignUp();

		if (signUpResult instanceof CustomerHome) {
			Assert.assertEquals(name, ((CustomerHome) signUpResult).getBanner());
			return factory.createCustomer((CustomerHome) signUpResult);
		} 
		
		return this;
	}

}
