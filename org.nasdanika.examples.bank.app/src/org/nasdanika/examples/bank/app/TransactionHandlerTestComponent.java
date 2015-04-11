package org.nasdanika.examples.bank.app;

import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;

public class TransactionHandlerTestComponent implements CDOTransactionHandler2 {
	
	public void activate(BundleContext context) {
		System.out.println("Transaction handler activated");
	}
	
	public void deactivate(BundleContext context) {
		System.out.println("Transaction handler deactivated");		
	}	

	@Override
	public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
		System.out.println("Transaction commited: "+transaction);
	}

	@Override
	public void committingTransaction(CDOTransaction arg0, CDOCommitContext arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rolledBackTransaction(CDOTransaction arg0) {
		// TODO Auto-generated method stub

	}
	
	public void setLogService(LogService ls) {
		System.out.println("Got log service");
		ls.log(LogService.LOG_WARNING, "It seems to be working!");
	}
	
	public void clearLogService(LogService ls) {
		System.out.println("Clearing log service");
	}

}
