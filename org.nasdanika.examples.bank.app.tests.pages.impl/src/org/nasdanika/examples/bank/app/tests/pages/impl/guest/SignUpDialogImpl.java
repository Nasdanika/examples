package org.nasdanika.examples.bank.app.tests.pages.impl.guest;

import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.app.tests.pages.guest.GuestHome;
import org.nasdanika.examples.bank.app.tests.pages.guest.SignUpDialog;
import org.nasdanika.examples.bank.app.tests.pages.impl.home.CustomerHomeImpl;
import org.nasdanika.webtest.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpDialogImpl implements SignUpDialog {

	private WebDriver driver;
	private WebDriverWait webDriverWait;

	public SignUpDialogImpl(WebDriver driver) {
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, 3);
	}
	
	private WebElement rId;
	private WebElement rName;
	private WebElement rPassword;
	private WebElement rPasswordConfirm;
	private WebElement signupSubmitButton;
	private WebElement signupCancelButton;

	@Override
	public SignUpDialog waitToAppear() {
		webDriverWait.until(ExpectedConditions.visibilityOf(rId));
		return this;
	}

	@Override
	public SignUpDialog enterOnlineId(String onlineId) {
		rId.sendKeys(onlineId);
		return this;
	}

	@Override
	public SignUpDialog enterName(String name) {
		rName.sendKeys(name);
		return this;
	}

	@Override
	public SignUpDialog enterPassword(String password) {
		rPassword.sendKeys(password);
		return this;
	}

	@Override
	public SignUpDialog enterPasswordConfirmation(String passwordConfirmation) {
		rPasswordConfirm.sendKeys(passwordConfirmation);
		return this;
	}

	@Override
	public Page clickSignUp() {
		signupSubmitButton.click();
		try {
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("banner")));
			return PageFactory.initElements(driver, CustomerHomeImpl.class);
		} catch (NotFoundException nfe) {
			return this;
		}
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

	@Override
	public GuestHome clickCancel() {
		signupCancelButton.click();
		webDriverWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(rId)));
		return new GuestHomeImpl(driver);
	}

}
