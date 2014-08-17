package org.nasdanika.examples.bank.app.tests.actors.impl;

import org.junit.Assert;
import org.nasdanika.examples.bank.app.tests.actors.BankActorFactory;
import org.nasdanika.examples.bank.app.tests.actors.Guest;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.app.tests.pages.guest.GuestHome;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Page;
import org.openqa.selenium.WebDriver;

class GuestImpl implements Guest {

	private BankActorFactory factory;
	private Page currentPage;
	private WebDriver webDriver;

	GuestImpl(BankActorFactory factory, WebDriver webDriver) {
		this.factory = factory;
		this.webDriver = webDriver;
	}

	@Override
	public Page getCurrentPage() {
		return currentPage;
	}

	@Override
	public Actor signIn(String onlineId, String password) {
		GuestHome home = factory.getPageFactory().createGuestHome(webDriver);
		home.enterOnlineId(onlineId);
		home.enterPassword(password);
		currentPage = home.clickSignIn();
		if (currentPage instanceof CustomerHome) {
			return factory.createCustomer(webDriver, (CustomerHome) currentPage);
		}
		return this;
	}

	@Override
	public Actor signUp(
			String onlineId, 
			String name, 
			String password,
			String passwordConfirmation) {
		GuestHome home = factory.getPageFactory().createGuestHome(webDriver);
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
			return factory.createCustomer(webDriver, (CustomerHome) signUpResult);
		} else {
			currentPage = signUpResult;
		}
		
		return this;
	}
	
	@Override
	public GuestHome goHome() {
		currentPage = factory.getPageFactory().createGuestHome(webDriver);
		((GuestHome) currentPage).open();
		return (GuestHome) currentPage;
	}
	

}
