package org.nasdanika.examples.bank.app.tests.pages.impl.guest;

import org.nasdanika.examples.bank.app.tests.pages.guest.GuestHome;
import org.nasdanika.examples.bank.app.tests.pages.guest.SignUpDialog;
import org.nasdanika.examples.bank.app.tests.pages.impl.BankPageFactoryImpl;
import org.nasdanika.webtest.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GuestHomeImpl implements GuestHome {
		
	private BankPageFactoryImpl factory;
	private WebDriver webDriver;

	public GuestHomeImpl(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void setFactory(BankPageFactoryImpl factory) {
		this.factory = factory;
	}
	
	private WebElement onlineId;
	private WebElement password;
	private WebElement signInButton;
	
	private WebElement signUpMenuItem;

	@Override
	public void enterOnlineId(String onlineId) {
		this.onlineId.sendKeys(onlineId);
	}

	@Override
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	@Override
	public Page clickSignIn() {
		this.signInButton.click();
		// TODO - match potential next pages.
		return null;
	}

	@Override
	public WebDriver getWebDriver() {
		return webDriver;
	}

	@Override
	public void open() {
		getWebDriver().get(factory.getBaseURL()+"/index.html");
		
	}

	@Override
	public SignUpDialog clickSignUp() {
		signUpMenuItem.click();
		return PageFactory.initElements(webDriver, SignUpDialogImpl.class);
	}

}
