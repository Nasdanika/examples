package org.nasdanika.examples.bank.app.tests;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppTest {
	
	private WebDriver driver;

	@Before
	public void waitForContainerStart() throws Exception {
		System.out.println("Waiting a bit for the OSGi container to start");
		Thread.sleep(5000);
        driver = new FirefoxDriver(); // new ChromeDriver();
	}

	@Test
	public void simpleTest() throws Exception {
        driver.get("http://localhost:8080/router/app.html");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshot.png");
		if (scrFile.renameTo(dest)) {
            System.out.println(dest.getAbsolutePath());        	
        }
     // Now you can do whatever you need to do with it, for example copy somewhere
//     FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
//        // Alternatively the same thing can be done like this
//        // driver.navigate().to("http://www.google.com");
//
//        // Find the text input element by its name
//        WebElement element = driver.findElement(By.name("q"));
//
//        // Enter something to search for
//        element.sendKeys("Cheese!");
//
//        // Now submit the form. WebDriver will find the form for us from the element
//        element.submit();
//
//        // Check the title of the page
//        System.out.println("Page title is: " + driver.getTitle());
//        
//        // Google's search is rendered dynamically with JavaScript.
//        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("cheese!");
//            }
//        });
//
//        // Should see: "cheese! - Google Search"
//        System.out.println("Page title is: " + driver.getTitle());
        
		
		System.out.println("Oh-oh!!!");
	}

	@After
	public void quitDriver() {
        //Close the browser
        driver.quit();		
	}
}
