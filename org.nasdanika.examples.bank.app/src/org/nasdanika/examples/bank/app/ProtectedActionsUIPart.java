package org.nasdanika.examples.bank.app;

import java.util.Map;

import org.nasdanika.html.NamedItemsContainer;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.html.UIPart;

public class ProtectedActionsUIPart implements UIPart<HttpContext, NamedItemsContainer<?>> {

	@Override
	public void create(HttpContext context, NamedItemsContainer<?> out,	Map<String, Object> environment) throws Exception {
		// if permission
		out.item("Protected actions", "Coming soon");
		
	}

}
