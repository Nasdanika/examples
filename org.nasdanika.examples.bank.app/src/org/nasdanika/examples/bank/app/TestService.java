package org.nasdanika.examples.bank.app;

import java.util.List;
import java.util.Map;

/**
 * Service interface for testing ServiceRoute
 * @author Pavel Vlasov
 *
 */
public interface TestService {
	
	Map<String, List<Object>> getMap(int id, String qualifier);

}
