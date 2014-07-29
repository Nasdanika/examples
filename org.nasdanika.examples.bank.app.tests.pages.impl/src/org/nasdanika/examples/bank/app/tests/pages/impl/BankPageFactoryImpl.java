package org.nasdanika.examples.bank.app.tests.pages.impl;

import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;
import org.nasdanika.examples.bank.app.tests.pages.guest.Home;
import org.nasdanika.examples.bank.app.tests.pages.impl.guest.HomeImpl;
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
	public Home createGuestHomePage() {
		HomeImpl ret = PageFactory.initElements(webDriver, HomeImpl.class);
		ret.setFactory(this);
		return ret;
	}
	
	public String getBaseURL() {
		return baseURL;
	}

}
