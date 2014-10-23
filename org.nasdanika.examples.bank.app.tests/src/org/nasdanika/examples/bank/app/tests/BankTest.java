package org.nasdanika.examples.bank.app.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.nasdanika.webtest.NasdanikaWebTestSuite;
import org.nasdanika.webtest.Title;

@RunWith(NasdanikaWebTestSuite.class)
@Title("Nasdanika Bank Web Tests Report")
@SuiteClasses({AppRouteDemo.class /*, SignUp.class, SignIn.class*/})
public class BankTest {
	
}
