/**
 */
package org.nasdanika.examples.bank.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.security.AuthorizationHelper;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.nasdanika.examples.bank.Account;
import org.nasdanika.examples.bank.BankFactory;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.CreditCard;
import org.nasdanika.examples.bank.Customer;
import org.nasdanika.examples.bank.PaymentProcessor;
import org.nasdanika.examples.bank.Product;
import org.nasdanika.examples.bank.SystemOfRecords;
import org.nasdanika.examples.bank.TransactionType;
import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.ApplicationPanel.ContentPanel;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Theme;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Navbar;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.DeviceSize;
import org.nasdanika.html.UIElement.Event;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.RouteMethod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getMemberOf <em>Member Of</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getProtectionDomain <em>Protection Domain</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getLogin <em>Login</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getPasswordHash <em>Password Hash</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#isDisabled <em>Disabled</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getAccounts <em>Accounts</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerImpl extends CDOObjectImpl implements Customer {
	private static final String UTF_8 = "UTF_8";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.CUSTOMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Group> getMemberOf() {
		return (EList<Group>)eGet(SecurityPackage.Literals.PRINCIPAL__MEMBER_OF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Permission> getPermissions() {
		return (EList<Permission>)eGet(SecurityPackage.Literals.PRINCIPAL__PERMISSIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProtectionDomain<?> getProtectionDomain() {
		return (ProtectionDomain<?>) eContainer(); //(ProtectionDomain<?>)eGet(SecurityPackage.Literals.PRINCIPAL__PROTECTION_DOMAIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Account> getAccounts() {
		return (EList<Account>)eGet(BankPackage.Literals.CUSTOMER__ACCOUNTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(BankPackage.Literals.CUSTOMER__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(BankPackage.Literals.CUSTOMER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogin() {
		return (String)eGet(SecurityPackage.Literals.LOGIN_PASSWORD_HASH_USER__LOGIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogin(String newLogin) {
		eSet(SecurityPackage.Literals.LOGIN_PASSWORD_HASH_USER__LOGIN, newLogin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getPasswordHash() {
		return (byte[])eGet(SecurityPackage.Literals.LOGIN_PASSWORD_HASH_USER__PASSWORD_HASH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordHash(byte[] newPasswordHash) {
		eSet(SecurityPackage.Literals.LOGIN_PASSWORD_HASH_USER__PASSWORD_HASH, newPasswordHash);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisabled() {
		return (Boolean)eGet(SecurityPackage.Literals.LOGIN_PASSWORD_HASH_USER__DISABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisabled(boolean newDisabled) {
		eSet(SecurityPackage.Literals.LOGIN_PASSWORD_HASH_USER__DISABLED, newDisabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void sendMessage(Principal from, String subject, String bodyMimeType, Object body) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void sendMessage(Principal from, String subject, Map<String, Object> bodyMap) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void sendMessage(Principal from, String subject, String body) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	private AuthorizationHelper authorizationHelper = new AuthorizationHelper(this);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AccessDecision authorize(SecurityPolicy securityPolicy, Context context, Object target, String action, String qualifier, Map<String, Object> environment) {
		return authorizationHelper.authorize(securityPolicy, context, target, action, qualifier, environment);
	}

	@RouteMethod(pattern="[^/]+\\.html")
	public String home(HttpContext context) throws Exception {
		HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
		if (!context.authorize(this, "read", null, null)) {
			return "Access denied!"; 			
		}
		ApplicationPanel appPanel = htmlFactory
				.applicationPanel()
				.width(800)
				.minHeight(600)
				.style(Style.PRIMARY)
				.header("Nasdanika Bank")
				.headerLink("/index.html");

		String objectPath = context.getObjectPath(this);
		Navbar navBar = htmlFactory.navbar(htmlFactory.span(StringEscapeUtils.escapeHtml4(getName())).id("banner"), objectPath+".html"); // Profile for authenticated user?		
		navBar.item(htmlFactory.link(objectPath+"/signout", "Sign out&nbsp;", htmlFactory.glyphicon(Glyphicon.log_out)).on(Event.click, "return confirm('Are you sure you want to sign out?');"), false, true);

		//Breadcrumbs breadcrumbs = htmlFactory.breadcrumbs();
		//for (TraceEntry te: context.getPathTrace()) {
		//	breadcrumbs.item(te.getPath(), te.getDisplayName());
		//}
		//breadcrumbs.item(null, StringEscapeUtils.escapeHtml4("Hi there"));		

		appPanel.navigation(navBar /*, breadcrumbs */);
		
		ContentPanel mainPanel = appPanel.contentPanel("Loading accounts panel...").id("main");
		
		Fragment rightPanelContent = htmlFactory.fragment();
		context.buildUICategory("right-panel", rightPanelContent, null);
		if (!rightPanelContent.isEmpty()) {
			mainPanel.width(DeviceSize.LARGE, 9);
			appPanel.contentPanel(rightPanelContent).width(DeviceSize.LARGE, 3);
		}
		
		appPanel.footer(htmlFactory.link("#", "Contact Us"));
		return htmlFactory.bootstrapRouterApplication(
				Theme.Default,
				"Nasdanika Bank", 
				"main/"+context.getObjectPath(this)+"/accounts.html", 
				null, 
				appPanel).toString();
	}
	
	@RouteMethod(pattern="[^/]+/accounts\\.html")
	public String accountsPanel(HttpContext context) throws Exception {
		HTMLFactory htmlFactory = context.adapt(HTMLFactory.class);
		if (!context.authorize(this, "read", null, null)) {
			return htmlFactory.alert(Style.DANGER, false, "Access Denied!").toString(); 
		}		
		Table accountsTable = htmlFactory.table();
		Row hRow = accountsTable.row().style(Style.INFO);
		hRow.header("Account");
		hRow.header("Balance").style("text-align", "right");
		for (Account a: getAccounts()) {
			Row aRow = accountsTable.row();
			aRow.cell(htmlFactory.routeLink(
					"main", 
					"/"+context.getObjectPath(a)+".html", 
					StringEscapeUtils.escapeHtml4(a.getProduct().getName()+"-"+a.cdoID())));
			aRow.cell(a.getBalance().negate()).attribute("align", "right");
		}
		return htmlFactory.panel(
				Style.INFO, 
				"Accounts", 
				accountsTable, 
				null).toString()+htmlFactory.title("Accounts");
	}
		
	@RouteMethod()
	public void signout(final HttpContext context) throws Exception {
		context.getRequest().getSession().invalidate();
		context.getResponse().sendRedirect(context.getObjectPath(eContainer())+".html");
	}	
	
	/**
	 * Initializes customer with random data.
	 */
	void init() {	
		
		PaymentProcessor visa = new PaymentProcessor() {
			
			@Override
			public void close() throws Exception {
				// NOP
				
			}
			
			private long counter;
			
			@Override
			public String transfer(
					TransactionType type, 
					String internalAccount,
					String externalAccount, 
					BigDecimal amount, 
					String id, 
					String comment) {
				
				return getId()+"/"+Long.toString(System.currentTimeMillis(), Character.MAX_RADIX)+"-"+Long.toString(++counter, Character.MAX_RADIX);
			}
			
			@Override
			public String getId() {
				return "Visa";
			}
		};
		
		PaymentProcessor ach = new PaymentProcessor() {
			
			@Override
			public void close() throws Exception {
				// NOP
				
			}
			
			private long counter;
			
			@Override
			public String transfer(
					TransactionType type, 
					String internalAccount,
					String externalAccount, 
					BigDecimal amount, 
					String id, 
					String comment) {
				
				return getId()+"/"+Long.toString(System.currentTimeMillis(), Character.MAX_RADIX)+"-"+Long.toString(++counter, Character.MAX_RADIX);
			}
			
			@Override
			public String getId() {
				return "ACH";
			}
		};		
		
		SystemOfRecords systemOfRecords = (SystemOfRecords) eContainer();
		for (Product p: systemOfRecords.getProducts()) {
			if (random.nextBoolean()) {
				CreditCard account = BankFactory.eINSTANCE.createCreditCard();
				account.setCreditLimit(new BigDecimal("15000.00"));
				account.setRate(new BigDecimal("0.072"));
				account.setGracePeriod(30);
				account.setBalance(BigDecimal.ZERO);
				account.setProduct(p);
				account.setPeriodStart(random.nextInt(28)+1);
				getAccounts().add(account);
				fillAccount(account, visa, ach);
			}
		}
		
	}
	
	private MessageFormat mf = new MessageFormat("{0,number,#.00}");
	
	private Random random = new Random(System.currentTimeMillis()+hashCode());
	
	private BigDecimal randomAmount(double from, double to) {
		double ram = from + random.nextDouble()*(to-from);		
		return new BigDecimal(mf.format(new Object[] {ram}));
	}

	private void fillAccount(Account account, PaymentProcessor cardProcessor, PaymentProcessor ach) {
		Calendar calendar = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		
		calendar.add(Calendar.MONTH, -4);
		
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		BigDecimal balance = BigDecimal.ZERO;
		for (; calendar.before(now); calendar.add(Calendar.DAY_OF_MONTH, random.nextInt(3)+1)) {
			switch (random.nextInt(5)) {
			case 0:
				balance = balance.add(account.transfer(
						TransactionType.DEBIT, 
						cardProcessor, 
						"WalMart", 
						calendar.getTime(), 
						randomAmount(23.8, 75.6), 
						"General merchandize").getAmount());
				break;
			case 1:
				balance = balance.add(account.transfer(
						TransactionType.DEBIT, 
						cardProcessor, 
						"McDonalds", 
						calendar.getTime(), 
						randomAmount(7.5, 14.9), 
						"Dining out").getAmount());
				break;
			case 2:
				balance = balance.add(account.transfer(
						TransactionType.DEBIT, 
						cardProcessor, 
						"DSW", 
						calendar.getTime(), 
						randomAmount(35, 120), 
						"Clothing and shoes").getAmount());
				break;
			case 3:
				balance = balance.add(account.transfer(
						TransactionType.DEBIT, 
						cardProcessor, 
						"Shell", 
						calendar.getTime(), 
						randomAmount(25, 56), 
						"Gasoline").getAmount());
				break;
			case 4:
				if (BigDecimal.ZERO.compareTo(balance)<0) {
					account.transfer(
							TransactionType.CREDIT, 
							ach, 
							"Automated transfer", 
							calendar.getTime(), 
							balance, 
							"Payment, thank you");
					balance = BigDecimal.ZERO;
				}
				break;
				
			}
		}				
	}
	

} //CustomerImpl
