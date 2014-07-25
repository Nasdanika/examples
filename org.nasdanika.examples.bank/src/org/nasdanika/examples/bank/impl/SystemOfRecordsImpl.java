/**
 */
package org.nasdanika.examples.bank.impl;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.security.Action;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.User;
import org.nasdanika.cdo.security.impl.LoginPasswordProtectionDomainImpl;
import org.nasdanika.core.NasdanikaException;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Customer;
import org.nasdanika.examples.bank.Guest;
import org.nasdanika.examples.bank.LoginPasswordCredentials;
import org.nasdanika.examples.bank.Product;
import org.nasdanika.examples.bank.SystemOfRecords;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.web.HttpContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Of Records</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getCustomers <em>Customers</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getProducts <em>Products</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getGuest <em>Guest</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemOfRecordsImpl extends LoginPasswordProtectionDomainImpl implements SystemOfRecords {
	private static final String UTF_8 = "UTF_8";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemOfRecordsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.SYSTEM_OF_RECORDS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eSet(BankPackage.Literals.SYSTEM_OF_RECORDS__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(BankPackage.Literals.SYSTEM_OF_RECORDS__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(BankPackage.Literals.SYSTEM_OF_RECORDS__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Customer> getCustomers() {
		return (EList<Customer>)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__CUSTOMERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Product> getProducts() {
		return (EList<Product>)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__PRODUCTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Guest getGuest() {
		return (Guest)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__GUEST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuest(Guest newGuest) {
		eSet(BankPackage.Literals.SYSTEM_OF_RECORDS__GUEST, newGuest);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<User> getAllUsers() {
		// Currently only customers. Add back-office workers in future versions.
		return new BasicEList<User>(getCustomers());
	}
	
	// --- Route methods ---
	
	/**
	 * Redirects to the principal home page.
	 * @param context
	 * @throws Exception
	 */
	@RouteMethod(pattern="[^/]+\\.html")
	public void home(HttpContext context) throws Exception {
		Principal principal = ((CDOViewContext<?,?>) context).getPrincipal();
		context.getResponse().sendRedirect(context.getObjectPath(principal)+".html");
	}	

	@RouteMethod(pattern="[^/]+/customers\\.html")
	public String customersList(HttpContext context) throws Exception {
		List<Object> cList = new ArrayList<>();
		for (Customer c: getCustomers()) {
			cList.add(context.getHTMLFactory().link(context.getObjectPath(c)+".html", StringEscapeUtils.escapeHtml4(c.getName())));
		}
		return context.getHTMLFactory().ol(cList).toString();
	}

} //SystemOfRecordsImpl
