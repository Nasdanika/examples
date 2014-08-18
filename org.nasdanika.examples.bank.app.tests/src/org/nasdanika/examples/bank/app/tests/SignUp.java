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
import org.nasdanika.examples.bank.app.tests.pages.guest.SignUpDialog;
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
public class SignUp implements WebTest {
	
	private static final String TEST_PASSWORD = "J0hn$D03";
	private static final String TEST_CUSTOMER_NAME = "John Doe";
	private static final String TEST_ONLINE_ID = "jDoe";
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
        // Explicit creation of page and actor factories.
        BankPageFactoryImpl pageFactoryImpl = new BankPageFactoryImpl();
        pageFactoryImpl.setBaseURL("http://localhost:8080");
		BankPageFactory pageFactory = NasdanikaWebTestRunner.proxyPageFactory(pageFactoryImpl);
        BankActorFactoryImpl actorFactoryImpl = new BankActorFactoryImpl();
        actorFactoryImpl.setPageFactory(pageFactory);
		actorFactory = NasdanikaWebTestRunner.proxyActorFactory(actorFactoryImpl);
	}
	
	@Test
	@Description("Successful registration")
	public void aHappyPath() throws Exception {
		Guest guest = actorFactory.createGuest(getWebDriver());
		guest.goHome();
		Actor customer = guest.signUp(TEST_ONLINE_ID, TEST_CUSTOMER_NAME, TEST_PASSWORD, TEST_PASSWORD);
		Assert.assertTrue(customer instanceof Customer);
		Assert.assertTrue(customer.getCurrentPage() instanceof CustomerHome);
		Assert.assertEquals(TEST_CUSTOMER_NAME, ((CustomerHome) customer.getCurrentPage()).getBanner());
	}
	
	@Test
	public void duplicateId() {
		Guest guest = actorFactory.createGuest(driver);
		guest.goHome();
		Actor actor = guest.signUp(TEST_ONLINE_ID, TEST_CUSTOMER_NAME, TEST_PASSWORD, TEST_PASSWORD);	
		Assert.assertTrue("Expected Guest, got "+actor, actor instanceof Guest);
		Assert.assertTrue("Expected SignuUp dialog, got "+actor.getCurrentPage(), actor.getCurrentPage() instanceof SignUpDialog);
		SignUpDialog signUpDialog = (SignUpDialog) actor.getCurrentPage();
		Assert.assertEquals("error: Online ID already exists", signUpDialog.getErrorMessage());
		signUpDialog.clickCancel();		
	}
	
	@Test
	@Description("All input fields are blank")
	public void allBlank() {
		
	}
	
	@Test
	public void blankId() {
		Guest guest = actorFactory.createGuest(driver);
		guest.goHome();
		Actor actor = guest.signUp(null, TEST_CUSTOMER_NAME, TEST_PASSWORD, TEST_PASSWORD);	
		Assert.assertTrue("Expected Guest, got "+actor, actor instanceof Guest);
		Assert.assertTrue("Expected Sign-up dialog, got "+actor.getCurrentPage(), actor.getCurrentPage() instanceof SignUpDialog);
		SignUpDialog signUpDialog = (SignUpDialog) actor.getCurrentPage();
		// Currently it is not possible to check HTML5 validation message with Selenium.
		Assert.assertEquals("", signUpDialog.getErrorMessage());
		signUpDialog.clickCancel();				
	}
		
	@Test
	public void shortId() {
		
	}
		
	@Test
	public void blankName() {
		
	}
		
	@Test
	public void blankPassword() {
		Guest guest = actorFactory.createGuest(driver);
		guest.goHome();
		Actor actor = guest.signUp(TEST_ONLINE_ID, TEST_CUSTOMER_NAME, null, TEST_PASSWORD);	
		Assert.assertTrue(actor instanceof Guest);
		Assert.assertTrue(actor.getCurrentPage() instanceof SignUpDialog);
		SignUpDialog signUpDialog = (SignUpDialog) actor.getCurrentPage();
		// Currently it is not possible to check HTML5 validation message with Selenium.
		Assert.assertEquals("", signUpDialog.getErrorMessage());
		signUpDialog.clickCancel();						
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
		Guest guest = actorFactory.createGuest(driver);
		guest.goHome();
		Actor actor = guest.signUp(TEST_ONLINE_ID, TEST_CUSTOMER_NAME, TEST_PASSWORD, null);	
		Assert.assertTrue(actor instanceof Guest);
		Assert.assertTrue(actor.getCurrentPage() instanceof SignUpDialog);
		SignUpDialog signUpDialog = (SignUpDialog) actor.getCurrentPage();
		// Currently it is not possible to check HTML5 validation message with Selenium.
		Assert.assertEquals("", signUpDialog.getErrorMessage());
		signUpDialog.clickCancel();						
	}
		
	@Test
	public void passwordsDoNotMatch() {
		Guest guest = actorFactory.createGuest(driver);
		guest.goHome();
		Actor actor = guest.signUp(TEST_ONLINE_ID, TEST_CUSTOMER_NAME, TEST_PASSWORD+"x", TEST_PASSWORD);	
		Assert.assertTrue(actor instanceof Guest);
		Assert.assertTrue(actor.getCurrentPage() instanceof SignUpDialog);
		SignUpDialog signUpDialog = (SignUpDialog) actor.getCurrentPage();
		Assert.assertEquals("Passwords don't match", signUpDialog.getErrorMessage());
		signUpDialog.clickCancel();				
	}
	
	@Test
	public void cancelSignUp() {
		
	}
	
	@After
	public void quitDriver() throws Exception {
		if (driver!=null) {
	        driver.quit();
	        driver = null;
		}
	}
	
}