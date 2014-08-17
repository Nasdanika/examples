package org.nasdanika.examples.bank.app.tests.pages.impl.guest;

import org.nasdanika.examples.bank.app.tests.pages.guest.SignInFailedDialog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInFailedDialogImpl implements SignInFailedDialog {
	
	private WebDriver driver;

	public SignInFailedDialogImpl(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "authentication-failed-modal")
	private WebElement dialog;

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

}
