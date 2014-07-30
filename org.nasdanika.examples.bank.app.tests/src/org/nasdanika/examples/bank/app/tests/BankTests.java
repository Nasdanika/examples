package org.nasdanika.examples.bank.app.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.nasdanika.webtest.NasdanikaTestSuite;
import org.nasdanika.webtest.Title;

@RunWith(NasdanikaTestSuite.class)
@Title("Nasdanika Bank Web Tests Report")
@SuiteClasses(Registration.class)
public class BankTests {
	
}
