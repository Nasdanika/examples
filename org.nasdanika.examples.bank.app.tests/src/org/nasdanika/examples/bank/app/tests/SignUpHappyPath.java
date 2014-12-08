package org.nasdanika.examples.bank.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.nasdanika.examples.bank.ui.driver.actors.BankActorFactory;
import org.nasdanika.examples.bank.ui.driver.actors.Customer;
import org.nasdanika.examples.bank.ui.driver.actors.Guest;
import org.nasdanika.examples.bank.ui.driver.pages.customer.CustomerHome;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.ActorFactory;
import org.nasdanika.webtest.Description;
import org.nasdanika.webtest.NasdanikaWebTestRunner;
import org.nasdanika.webtest.Screenshot;
import org.nasdanika.webtest.WebTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(NasdanikaWebTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Description("Tests of sign-up happy path scenario for quick testing.")
public class SignUpHappyPath implements WebTest<WebDriver> {
	
	private static final String TEST_PASSWORD = "J123_D45";
	private static final String TEST_CUSTOMER_NAME = "John Doe";
	private static final String TEST_ONLINE_ID = "jDoe";
	private WebDriver driver;
	
	@Override
	public WebDriver getWebDriver() {
		return driver;
	}
		
	@ActorFactory
	public BankActorFactory actorFactory;

	@Before
	public void setUp() throws Exception {
        driver = new FirefoxDriver(); // new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
	}
	
	@Test
	@Description("Successful registration")
	@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})
	public void aHappyPath() throws Exception {
		Guest guest = actorFactory.createGuest(getWebDriver());
		guest.goHome();
		Actor<WebDriver> customer = guest.signUp(TEST_ONLINE_ID, TEST_CUSTOMER_NAME, TEST_PASSWORD, TEST_PASSWORD);
		Assert.assertTrue(customer instanceof Customer);
		Assert.assertTrue(customer.getCurrentPage() instanceof CustomerHome);
		Assert.assertEquals(TEST_CUSTOMER_NAME, ((CustomerHome) customer.getCurrentPage()).getBanner());
	}
	
	@After
	public void quitDriver() throws Exception {
		if (driver!=null) {
	        driver.quit();
	        driver = null;
		}
	}

	@Override
	public long getScreenshotDelay() {
		return 0;
	}
	
}
