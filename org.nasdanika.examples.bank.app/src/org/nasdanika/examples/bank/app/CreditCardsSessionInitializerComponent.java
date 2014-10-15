package org.nasdanika.examples.bank.app;

import java.util.logging.Logger;

import org.eclipse.emf.cdo.common.model.CDOPackageRegistry;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.eclipse.emf.cdo.util.CommitException;
import org.nasdanika.cdo.CDOSessionInitializer;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.SecurityFactory;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.examples.bank.BankFactory;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Guest;
import org.nasdanika.examples.bank.Product;
import org.nasdanika.examples.bank.SystemOfRecords;

public class CreditCardsSessionInitializerComponent implements CDOSessionInitializer {
	
	@Override
	public void init(CDOSession session) {
		CDOPackageRegistry packageRegistry = session.getPackageRegistry();
		packageRegistry.putEPackage(BankPackage.eINSTANCE);
		packageRegistry.putEPackage(SecurityPackage.eINSTANCE);
		
		// Populate with sample data if empty.
		CDOTransaction transaction = session.openTransaction();
				
		try {
			CDOResource cRes = transaction.getOrCreateResource("/bank");
			if (cRes.getContents().isEmpty()) {
				final SystemOfRecords sor = BankFactory.eINSTANCE.createSystemOfRecords();
				sor.setId("cdo-repo");
				sor.setName("Nasdanika Bank");
				sor.setDescription("CDO repository is a system of records for Nasdanika Bank");
				cRes.getContents().add(sor);
				
				((CDOTransaction) sor.cdoView()).addTransactionHandler(new CDOTransactionHandler2() {

					@Override
					public void committingTransaction(
							CDOTransaction transaction,
							CDOCommitContext commitContext) {
						// TODO Auto-generated method stub
						System.out.println("Transaction committing, sor: "+sor);
						
					}

					@Override
					public void committedTransaction(
							CDOTransaction transaction,
							CDOCommitContext commitContext) {
						// TODO Auto-generated method stub
						Logger.getLogger(getClass().getName()).severe("Transaction committed, sor: "+sor);
					}

					@Override
					public void rolledBackTransaction(CDOTransaction transaction) {
						// TODO Auto-generated method stub
						
					}
				});
				
				// Guest
				Guest guest = BankFactory.eINSTANCE.createGuest();
				sor.setGuest(guest);
				sor.setUnauthenticatedPrincipal(guest);		
				
				// Permissions				
				Permission productPermission = SecurityFactory.eINSTANCE.createPermission();
				productPermission.setAllow(true);
				productPermission.setName("read");
				productPermission.setTargetClass("Product");
				productPermission.setTargetNamespaceURI("urn:org.nasdanika.examples.bank");
				guest.getPermissions().add(productPermission);
				
				Permission servicePermission = SecurityFactory.eINSTANCE.createPermission();
				servicePermission.setAllow(true);
				servicePermission.setName("invoke");
				servicePermission.setTargetClass("TestService");
				servicePermission.setTargetNamespaceURI("java://org.nasdanika.examples.bank.app");
				guest.getPermissions().add(servicePermission);				
				
				Permission userPermission = SecurityFactory.eINSTANCE.createPermission();
				userPermission.setTarget(guest); // self-target
				userPermission.setAllow(true);
				userPermission.setName("*");
				userPermission.setTargetClass("User");
				userPermission.setTargetNamespaceURI("urn:org.nasdanika.cdo.security");
				guest.getPermissions().add(userPermission);
				
				// Products
				Product serenity = BankFactory.eINSTANCE.createProduct();
				serenity.setName("Serenity");
				sor.getProducts().add(serenity);
				
				Product serendipity = BankFactory.eINSTANCE.createProduct();
				serendipity.setName("Serendipity");
				sor.getProducts().add(serendipity);
								
				Product emerald = BankFactory.eINSTANCE.createProduct();
				emerald.setName("Emerald");
				sor.getProducts().add(emerald);
				
				System.out.println("Bank model generated");
			}
			
			transaction.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
	}

}
