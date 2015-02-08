package org.nasdanika.examples.bank.app.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.nasdanika.webtest.NasdanikaWebTestSuite;
import org.nasdanika.webtest.Title;

//@SuiteClasses({SignUpHappyPath.class})
@SuiteClasses({AppRouteDemo.class,  SignUp.class, SignIn.class})
@RunWith(NasdanikaWebTestSuite.class)
@Title("Sub-suite of tests")
public class SubSuite {

}
