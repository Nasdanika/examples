package org.nasdanika.examples.bank.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nasdanika.examples.bank.app.tests.actors.BankActorFactory;
import org.nasdanika.examples.bank.app.tests.actors.impl.BankActorFactoryImpl;
import org.nasdanika.examples.bank.app.tests.pages.BankPageFactory;
import org.nasdanika.examples.bank.app.tests.pages.impl.BankPageFactoryImpl;
import org.nasdanika.webtest.NasdanikaTestRunner;
import org.nasdanika.webtest.Report;
import org.nasdanika.webtest.Title;
import org.nasdanika.webtest.WebTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(NasdanikaTestRunner.class)
//@Report(outputDir="C:\\_temp\\TestReport")
@Title("Nasdanika Bank Web Tests Report")
public class AppTest implements WebTest {
	
	private WebDriver driver;
	private BankActorFactory actorFactory;

	@Before
	public void setUp() throws Exception {
		System.out.println("Waiting a bit for the OSGi container to start");
		Thread.sleep(1000);
        driver = new FirefoxDriver(); // new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        BankPageFactory pageFactory = NasdanikaTestRunner.proxyPageFactory(new BankPageFactoryImpl(driver, "http://localhost:8080"));
        actorFactory = NasdanikaTestRunner.proxyActorFactory(new BankActorFactoryImpl(pageFactory));
	}
	
	@Test
	@Title("Sign-in")
	public void signIn() throws Exception {
		actorFactory.createGuest().signIn("a", "b");
		Thread.sleep(1000);
		//fail("Just to test");
	}
	
	@Test
	public void yet() {
		
	}

	@After
	public void quitDriver() throws Exception {
		//Thread.sleep(5000); // For visual inpsection.
        //Close the browser
        driver.quit();
        driver = null;
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}
}
