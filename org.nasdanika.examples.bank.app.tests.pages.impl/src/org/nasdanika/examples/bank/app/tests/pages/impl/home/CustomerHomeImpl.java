package org.nasdanika.examples.bank.app.tests.pages.impl.home;

import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerHomeImpl implements CustomerHome {

	private WebDriver driver;
	
	private WebElement banner;

	public CustomerHomeImpl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

	@Override
	public String getBanner() {
		return banner.getText();
	}

}
