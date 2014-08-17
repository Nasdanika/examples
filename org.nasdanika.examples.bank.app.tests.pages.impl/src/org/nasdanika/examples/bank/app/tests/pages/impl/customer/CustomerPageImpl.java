package org.nasdanika.examples.bank.app.tests.pages.impl.customer;

import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerPage;
import org.nasdanika.webtest.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Base class for customer pages.
 * @author Pavel Vlasov
 *
 */
public class CustomerPageImpl implements CustomerPage {

	private WebDriver driver;
	
	private WebElement banner;

	protected CustomerPageImpl(WebDriver driver) {
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

	@Override
	public CustomerPage clickSignOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page confirmSignOut(boolean confirm) {
		// TODO Auto-generated method stub
		return null;
	}

}
