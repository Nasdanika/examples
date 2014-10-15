package org.nasdanika.examples.bank.app;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TestServiceComponent implements TestService {
	
	@Override
	public Map<String, List<Object>> getMap(final int id, final String qualifier) {
		return Collections.singletonMap(qualifier, Collections.<Object>singletonList(new String[] {String.valueOf(id)}));
	}

}
