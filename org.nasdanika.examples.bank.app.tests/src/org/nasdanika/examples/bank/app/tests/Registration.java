package org.nasdanika.examples.bank.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.nasdanika.examples.bank.app.tests.actors.BankActorFactory;
import org.nasdanika.examples.bank.app.tests.actors.Customer;
import org.nasdanika.examples.bank.app.tests.actors.Guest;
import org.nasdanika.examples.bank.app.tests.actors.impl.BankActorFactoryImpl;
import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;
import org.nasdanika.examples.bank.app.tests.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.app.tests.pages.impl.BankPageFactoryImpl;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Description;
import org.nasdanika.webtest.NasdanikaWebTestRunner;
import org.nasdanika.webtest.WebTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(NasdanikaWebTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Description("Tests of registration scenarios")
public class Registration implements WebTest {
	
	private WebDriver driver;
	
	@Override
	public WebDriver getWebDriver() {
		return driver;
	}
	
	private BankActorFactory actorFactory;

	@Before
	public void setUp() throws Exception {
        driver = new FirefoxDriver(); // new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        BankPageFactory pageFactory = NasdanikaWebTestRunner.proxyPageFactory(new BankPageFactoryImpl(driver, "http://localhost:8080"));
        actorFactory = NasdanikaWebTestRunner.proxyActorFactory(new BankActorFactoryImpl(pageFactory));
	}
	
	@Test
	@Description("Successful registration")
	public void aHappyPath() throws Exception {
		Guest guest = actorFactory.createGuest();
		Actor customer = guest.signUp("jDoe", "John Doe", "J0hn$D03", "J0hn$D03");
		Assert.assertTrue(customer instanceof Customer);
		Assert.assertTrue(customer.getCurrentPage() instanceof CustomerHome);
		Assert.assertEquals("John Doe", ((CustomerHome) customer.getCurrentPage()).getBanner());
	}
	
	@Test
	public void duplicateId() {
		
	}
	
	@Test
	@Description("All input fields are blank")
	public void allBlank() {
		
	}
	
	@Test
	public void blankId() {
		
	}
		
	@Test
	public void shortId() {
		
	}
		
	@Test
	public void blankName() {
		
	}
		
	@Test
	public void blankPassword() {
		
	}
	
	@Test
	@Description("Password shall be minimum 6 characters long")
	public void shortPassword() {
		
	}
			
	@Test
	@Description("Password shall contain 3 out of 4 character classes - lower case letters, upper case letters, numbers, special characters like _, @, #, $")
	public void weakPassword() {
		
	}
		
	@Test
	public void blankPasswordConfirm() {
		
	}
		
	@Test
	public void passwordsDoNotMatch() {
		
	}
	
	@Test
	public void cancelRegistration() {
		
	}
	
	@After
	public void quitDriver() throws Exception {
		if (driver!=null) {
	        driver.quit();
	        driver = null;
		}
	}
	
}
