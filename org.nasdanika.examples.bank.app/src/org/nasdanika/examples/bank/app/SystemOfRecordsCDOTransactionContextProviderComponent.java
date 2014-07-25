package org.nasdanika.examples.bank.app;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.CDOTransactionContextProviderComponent;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.examples.bank.LoginPasswordCredentials;

public class SystemOfRecordsCDOTransactionContextProviderComponent extends	CDOTransactionContextProviderComponent<LoginPasswordCredentials> {

	@SuppressWarnings("unchecked")
	@Override
	protected ProtectionDomain<LoginPasswordCredentials> getProtectionDomain(CDOTransaction view) {
		CDOResource bankRes = view.getResource("bank");
		if (bankRes!=null) {
			for (EObject e: bankRes.getContents()) {
				if (e instanceof ProtectionDomain) {
					return (ProtectionDomain<LoginPasswordCredentials>) e;
				}
			}
		}
		return null;
	}

}
