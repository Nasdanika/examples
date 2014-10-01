package org.nasdanika.examples.bank.app.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nasdanika.examples.bank.ui.driver.actors.BankActorFactory;
import org.nasdanika.webtest.ActorFactory;
import org.nasdanika.webtest.Description;
import org.nasdanika.webtest.NasdanikaWebTestRunner;
import org.nasdanika.webtest.Screenshot;
import org.nasdanika.webtest.WebTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(NasdanikaWebTestRunner.class)
@Description("Demonstrates capabilities of Nasdanika HTML by rendering and taking a screenshot of AppRoute")
public class AppRouteDemo implements WebTest<WebDriver> {
	
	private static final String TEST_PASSWORD = "J0hn$D03";
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
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@Test
	@Description("Demo of Nasdanika HTML")
	@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})
	public void appRoute() throws Exception {
		getWebDriver().get("http://localhost:8080/router/app.html");
		new WebDriverWait(getWebDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("offer-of-the-day")));		
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
