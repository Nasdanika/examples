package org.nasdanika.examples.bank.app.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.nasdanika.examples.bank.ui.driver.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.ui.driver.pages.guest.GuestHome;
import org.nasdanika.examples.bank.ui.driver.pages.guest.SignInFailedDialog;
import org.nasdanika.examples.bank.ui.driver.actors.BankActorFactory;
import org.nasdanika.examples.bank.ui.driver.actors.Customer;
import org.nasdanika.examples.bank.ui.driver.actors.Guest;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.ActorFactory;
import org.nasdanika.webtest.Description;
import org.nasdanika.webtest.NasdanikaParameterizedWebTestRunner;
import org.nasdanika.webtest.Screenshot;
import org.nasdanika.webtest.Title;
import org.nasdanika.webtest.WebTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

@RunWith(NasdanikaParameterizedWebTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignIn implements WebTest<WebDriver> {
	
	public enum Browser { firefox, chrome , iexplorer }
	
	@Parameters(name="{index}: {0}")
	public static Collection<Object[]> registrationData() {
		return Arrays.asList(new Object[][] { {Browser.firefox} , {Browser.chrome} /*, {Browser.iexplorer} */ });
	}
	
	@Parameter
	@Title("Browser")
	public Browser browser;	
	
	private static final String TEST_ONLINE_ID = "janeDoe";
	private static final String TEST_CUSTOMER_NAME = "Jane Doe";
	private static final String TEST_PASSWORD = "J123_D45";
	
	private WebDriver driver;
	
	@ActorFactory
	public BankActorFactory actorFactory;

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}
	
	@Before
	public void setUp() throws Exception {		
		//String browser = System.getenv("browser");
		if (browser==null || Browser.chrome.equals(browser)) {
			driver = new ChromeDriver();
		} else if (Browser.firefox.equals(browser)) {
			driver = new FirefoxDriver();		
		} else if (Browser.iexplorer.equals(browser)) {
			driver = new InternetExplorerDriver();
		} else {
			throw new IllegalArgumentException("Unexpected browser: "+browser);
		}
	}

	@Test
	@Title("Sign up a new customer")
	@Description("Helper test - Creates a new customer account to use in tests.")
	@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})
	public void _SignUpCustomer() throws Exception {
		Guest guest = actorFactory.createGuest(getWebDriver());
		guest.goHome();
		Actor<WebDriver> customer = guest.signUp(TEST_ONLINE_ID+"_"+browser, TEST_CUSTOMER_NAME, TEST_PASSWORD, TEST_PASSWORD);
		Assert.assertTrue(customer instanceof Customer);
		Assert.assertTrue(customer.getCurrentPage() instanceof CustomerHome);
		Assert.assertEquals(TEST_CUSTOMER_NAME, ((CustomerHome) customer.getCurrentPage()).getBanner());
	}

	@Test
	@Title("Sign-In")
	@Description("Tests successful sign-in")
	@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})
	public void signIn() throws Exception {
		Guest guest = actorFactory.createGuest(driver);
		guest.goHome();
		Actor<WebDriver> actor = guest.signIn(TEST_ONLINE_ID+"_"+browser, TEST_PASSWORD);	
		Assert.assertTrue(actor instanceof Customer);
		Assert.assertTrue(actor.getCurrentPage() instanceof CustomerHome);
		Assert.assertEquals(TEST_CUSTOMER_NAME, ((CustomerHome) actor.getCurrentPage()).getBanner());
	}
	
	@Test
	@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})
	public void invalidCredentials() {
		Guest guest = actorFactory.createGuest(driver);
		guest.goHome();
		Actor<WebDriver> actor = guest.signIn(TEST_ONLINE_ID+"_"+browser, TEST_PASSWORD+"_1234");	
		Assert.assertTrue(actor instanceof Guest);
		Assert.assertTrue(actor.getCurrentPage() instanceof SignInFailedDialog);
	}

	@Test
	@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})
	public void emptyOnlineId() {
		Guest guest = actorFactory.createGuest(driver);
		guest.goHome();
		Actor<WebDriver> actor = guest.signIn(null, TEST_PASSWORD);	
		Assert.assertTrue(actor instanceof Guest);
		Assert.assertTrue(actor.getCurrentPage() instanceof GuestHome);
	}

	@Test
	@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})
	public void emptyPassword() {
		Guest guest = actorFactory.createGuest(driver);
		guest.goHome();
		Actor<WebDriver> actor = guest.signIn(TEST_ONLINE_ID, null);	
		Assert.assertTrue(actor instanceof Guest);
		Assert.assertTrue(actor.getCurrentPage() instanceof GuestHome);
	}

	@After
	public void quitDriver() {		
        //Close the browser
        driver.quit();	
        driver = null;
	}

	@Override
	public long getScreenshotDelay() {
		return 0;
	}
	
}
