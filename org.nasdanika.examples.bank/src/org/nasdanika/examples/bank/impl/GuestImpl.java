/**
 */
package org.nasdanika.examples.bank.impl;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.security.AuthorizationHelper;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.User;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.nasdanika.examples.bank.BankFactory;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Customer;
import org.nasdanika.examples.bank.Guest;
import org.nasdanika.examples.bank.Product;
import org.nasdanika.examples.bank.SystemOfRecords;
import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.ApplicationPanel.ContentPanel;
import org.nasdanika.html.Button.Type;
import org.nasdanika.html.Form;
import org.nasdanika.html.Form.Method;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.Modal;
import org.nasdanika.html.Navbar;
import org.nasdanika.html.UIElement.DeviceSize;
import org.nasdanika.html.UIElement.Event;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.RouteMethod;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.GuestImpl#getMemberOf <em>Member Of</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.GuestImpl#getPermissions <em>Permissions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuestImpl extends CDOObjectImpl implements Guest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.GUEST;
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
	public void sendMessage(Principal from, String subject, String bodyMimeType, Object body) {
		// NOP
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void sendMessage(Principal from, String subject, Map<String, Object> bodyMap) {
		// NOP
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void sendMessage(Principal from, String subject, String body) {
		// NOP
	}

	private AuthorizationHelper authorizationHelper = new AuthorizationHelper() {
		
		@Override
		protected ProtectionDomain<?> getProtectionDomain() {
			return (ProtectionDomain<?>) GuestImpl.this.eContainer();
		}
		
		@Override
		protected Principal getPrincipal() {
			return GuestImpl.this;
		}
	};
		
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String testOp(String p1, int p2) {
		return "Hello, "+p1+", "+p2+" times!!!";
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AccessDecision authorize(Context context, EObject target, String action, String qualifier, Map<String, Object> environment) {
		return authorizationHelper.authorize(context, target, action, qualifier, environment);
	}
	
	// --- Route methods ---
	
	@RouteMethod(pattern="[^/]+\\.html")
	public String home(HttpContext context) throws Exception {
		HTMLFactory htmlFactory = context.getHTMLFactory();
		String objectPath = context.getObjectPath(this);
		ApplicationPanel appPanel = htmlFactory.applicationPanel()
				.style(Style.INFO) // Guest INFO, Authenticated user - primary.
				.header(StringEscapeUtils.escapeHtml4(((SystemOfRecords) eContainer()).getName()))
				.width(800)
				.minHeight(600)
				.headerLink("/index.html")
				.footer(
						htmlFactory.link("#", "Contact us"), 
						"&nbsp;&middot;&nbsp;", 
						htmlFactory.link("#", "Privacy Policy"));
		
		Navbar navBar = htmlFactory.navbar("Welcome!", objectPath+".html"); 
		
		Form signinForm = navBar.form(true).method(Method.post).action(objectPath+"/signin");
		Input onlineId = htmlFactory.input(InputType.text)
				.name("onlineId")
				.id("onlineId")
				.placeholder("Online ID")
				.required();
		
		signinForm.formGroup("Online ID", "onlineId", onlineId, null);

		signinForm.content(" ");
		
		// TODO - multi-factor authentication - password in a dialog with an image confirming site identity 		
		Input password = htmlFactory.input(InputType.password)
				.name("password")
				.id("password")
				.placeholder("Password")
				.required();
		
		signinForm.formGroup(null, "password", password, null);
		signinForm.content(" ");
		
		signinForm.button("Sign In&nbsp;", htmlFactory.glyphicon(Glyphicon.log_in)).type(Type.SUBMIT).id("signInButton");
		
		signinForm.on(Event.submit,
				htmlFactory.require(
						htmlFactory.function("signin").code("signin(this);").bind("this"), 
						objectPath+"/resource/signin.js")+"; return false;");
		
		navBar.item(htmlFactory.link("#", "Sign up").on(Event.click, "jQuery('#sign-up-form-modal').modal();"), false, true);
		
		appPanel.navigation(navBar);		
		
		ContentPanel mainPanel = appPanel.contentPanel()
			.id("main")
			.width(DeviceSize.SMALL, 9)
			.width(DeviceSize.MEDIUM, 10)
			.width(DeviceSize.LARGE, 11);
		
		for (Product product: ((SystemOfRecords) eContainer()).getProducts()) {
			mainPanel.content(htmlFactory.alert(Style.SUCCESS, false, htmlFactory.link(context.getObjectPath(product)+".html", StringEscapeUtils.escapeHtml4(product.getName()))));
		}
				
		Modal authenticationFailedModal = htmlFactory.modal()
				.id("authentication-failed-modal")
				.small()
				.title("Authentication failed")
				.body("Invalid Online ID/Password combination");
		
		Form signupForm = htmlFactory.form()
				.method(Method.post)
				.action(objectPath+"/signup")
				.id("signup-form");
		
		signupForm.content(htmlFactory.div("").style("color", "red").id("error-message"));
		
		Input rId = htmlFactory.input(InputType.text)
				.name("onlineId")
				.id("rId")
				.placeholder("Online ID")
				.autofocus()
				.required();
		
		signupForm.formGroup("Online ID", "rId", rId, null);
		signupForm.content(" ");
		
		Input rName = htmlFactory.input(InputType.text)
				.name("customerName")
				.id("rName")
				.placeholder("Name")
				.required();
		
		signupForm.formGroup("Name", "rName", rName, null);
		signupForm.content(" ");
		
		Input rPassword = htmlFactory.input(InputType.password)
				.name("password")
				.id("rPassword")
				.placeholder("Password")
				.required();
		
		signupForm.formGroup("Password", "rPassword", rPassword, null);
		signupForm.content(" ");
		
		Input rPasswordConfirm = htmlFactory.input(InputType.password)
				.name("passwordConfirm")
				.id("rPasswordConfirm")
				.placeholder("Confirm password")
				.required();
		
		signupForm.formGroup("Confirm password", "rPasswordConfirm", rPasswordConfirm, null);
		signupForm.content(" ");
		
		signupForm.button("Sign up").type(Type.SUBMIT).style(Style.PRIMARY);
		signupForm.content("&nbsp;");
		signupForm.button("Cancel").attribute("data-dismiss", "modal");
		
		signupForm.on(Event.submit, getClass().getResourceAsStream("GuestImpl$signup.js")); 
		
		Modal signupFormModal = htmlFactory.modal()
				.id("sign-up-form-modal")
				.small()
				.title("Sign up to online banking")
				.body(signupForm);
				
		return htmlFactory.routerApplication("Nasdanika Bank", null, null, appPanel, signupFormModal, authenticationFailedModal).toString();
		
	}
	
	@RouteMethod(value=RequestMethod.POST)
	public Object signin(final HttpContext context) throws Exception {
		@SuppressWarnings("unchecked")
		Principal authenticatedPrincipal = ((CDOViewContext<?,LoginPasswordCredentials>) context).authenticate(new LoginPasswordCredentials() {
			
			@Override
			public String getPassword() {
				return context.getRequest().getParameter("password");
			}
			
			@Override
			public String getLogin() {
				return context.getRequest().getParameter("onlineId");
			}
		});
		if (authenticatedPrincipal==null) {
			context.getResponse().sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
		return context.getObjectPath(authenticatedPrincipal)+".html";
	}	
	
	@SuppressWarnings("unchecked")
	@RouteMethod(value=RequestMethod.POST)
	public Object signup(final HttpContext context) throws Exception {
		// Server-side validation
		final String onlineId = context.getRequest().getParameter("onlineId");
		if (onlineId==null || onlineId.trim().length()==0) {
			context.getResponse().sendError(HttpServletResponse.SC_BAD_REQUEST, "Online ID is blank");
			return null;
		}
		
		final String name = context.getRequest().getParameter("customerName");
		if (name==null || name.trim().length()==0) {
			context.getResponse().sendError(HttpServletResponse.SC_BAD_REQUEST, "Name is blank");
			return null;
		}
		
		final String password = context.getRequest().getParameter("password");
		if (password==null || password.trim().length()==0) {
			context.getResponse().sendError(HttpServletResponse.SC_BAD_REQUEST, "Password is blank");
			return null;
		}
		
		String passwordConfirm = context.getRequest().getParameter("passwordConfirm");
		if (passwordConfirm==null || passwordConfirm.trim().length()==0) {
			context.getResponse().sendError(HttpServletResponse.SC_BAD_REQUEST, "Password confirmation is blank");
			return null;
		}
		
		if (!password.equals(passwordConfirm)) {
			context.getResponse().sendError(HttpServletResponse.SC_BAD_REQUEST, "Passwords don't match");
			return null;			
		}
		
		// TODO - min length, strength checks.
		
		SystemOfRecords systemOfRecords = (SystemOfRecords) eContainer();
		for (User u: systemOfRecords.getAllUsers()) {
			if (u instanceof LoginPasswordHashUser) {
				LoginPasswordHashUser lphUser = (LoginPasswordHashUser) u;
				if (lphUser.getLogin()!=null && lphUser.getLogin().equalsIgnoreCase(onlineId)) {
					context.getResponse().sendError(HttpServletResponse.SC_BAD_REQUEST, "Online ID already exists");
					return null;					
				}
			}
		}
		Customer newCustomer = BankFactory.eINSTANCE.createCustomer();
		newCustomer.setLogin(onlineId);
		newCustomer.setName(name);
		systemOfRecords.setPasswordHash(newCustomer, password);
		systemOfRecords.getCustomers().add(newCustomer);
		
		((CustomerImpl) newCustomer).init();
		
		Principal authenticatedUser = ((CDOViewContext<CDOView, LoginPasswordCredentials>) context).authenticate(new LoginPasswordCredentials() {
			
			@Override
			public String getPassword() {
				return password;
			}
			
			@Override
			public String getLogin() {
				return onlineId;
			}
		});
		
		if (newCustomer!=authenticatedUser) {
			context.getResponse().sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Sign up failed - internal error");
			return null;
		}
		
		 // Double redirect because new user OID is not available.
		return context.getObjectPath(systemOfRecords)+".html"; // +"/operation/getUser/"+onlineId+"/home.html";
	}	
	

} //GuestImpl
