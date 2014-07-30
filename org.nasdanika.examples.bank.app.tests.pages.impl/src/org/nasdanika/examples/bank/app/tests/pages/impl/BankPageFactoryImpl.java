package org.nasdanika.examples.bank.app.tests.pages.impl;

import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.app.tests.pages.guest.GuestHome;
import org.nasdanika.examples.bank.app.tests.pages.impl.guest.GuestHomeImpl;
import org.nasdanika.examples.bank.app.tests.pages.impl.home.CustomerHomeImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BankPageFactoryImpl implements BankPageFactory {

	private WebDriver webDriver;
	private String baseURL;

	public BankPageFactoryImpl(WebDriver webDriver, String baseURL) {
		this.webDriver = webDriver;
		this.baseURL = baseURL;
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

	@Override
	public GuestHome createGuestHome() {
		GuestHomeImpl ret = PageFactory.initElements(webDriver, GuestHomeImpl.class);
		ret.setFactory(this);
		return ret;
	}
	
	public String getBaseURL() {
		return baseURL;
	}

	@Override
	public CustomerHome createCustomerHome() {
		return PageFactory.initElements(webDriver, CustomerHomeImpl.class);
	}

}
