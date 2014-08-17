package org.nasdanika.examples.bank.app.tests.pages.impl;

import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.app.tests.pages.guest.GuestHome;
import org.nasdanika.examples.bank.app.tests.pages.impl.customer.CustomerHomeImpl;
import org.nasdanika.examples.bank.app.tests.pages.impl.guest.GuestHomeImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.osgi.service.component.ComponentContext;

public class BankPageFactoryImpl implements BankPageFactory {

	private String baseURL;
	
	public void activate(ComponentContext context) {
		baseURL = (String) context.getProperties().get("base-url");
	}
	
	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}
	
	@Override
	public GuestHome createGuestHome(WebDriver webDriver) {
		GuestHomeImpl ret = PageFactory.initElements(webDriver, GuestHomeImpl.class);
		ret.setFactory(this);
		return ret;
	}
	
	public String getBaseURL() {
		return baseURL;
	}
	
	@Override
	public CustomerHome createCustomerHome(WebDriver webDriver) {
		new WebDriverWait(webDriver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));
		return PageFactory.initElements(webDriver, CustomerHomeImpl.class);
	}

}
