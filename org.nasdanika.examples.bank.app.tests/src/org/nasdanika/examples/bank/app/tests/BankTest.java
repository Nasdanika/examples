package org.nasdanika.examples.bank.app.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.nasdanika.webtest.NasdanikaWebTestSuite;
import org.nasdanika.webtest.Publish;
import org.nasdanika.webtest.Report;
import org.nasdanika.webtest.Title;

@SuiteClasses({AppRouteDemo.class,  SignUp.class, SignIn.class})
@RunWith(NasdanikaWebTestSuite.class)
@Title("Nasdanika Bank Web Tests Report")
@Report
@Publish(url="http://localhost:18080/router/transaction/elements/WebTestHub/L5/testSessions", securityToken="secret")
public class BankTest {
	
}
