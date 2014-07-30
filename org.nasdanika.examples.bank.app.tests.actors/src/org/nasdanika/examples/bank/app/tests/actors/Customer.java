package org.nasdanika.examples.bank.app.tests.actors;

import org.nasdanika.webtest.Actor;

public interface Customer extends Actor {
	
	Actor signOut(boolean confirm);

}
