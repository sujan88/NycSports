package mum.edu.waa.nycsports.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.waa.nycsports.domain.UserCredentials;
import mum.edu.waa.nycsports.service.AuthorityService;
import mum.edu.waa.nycsports.service.UserCredentialService;
import mum.edu.waa.nycsports.validator.UserCredentialValidator;

@Controller
public class RegisterController {
	@Autowired
	private UserCredentialService userCredentialService;
	
	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private MessageSource messageSource;
	
	//Qualifier the AuthenticationManager with the name same as name of AuthenticationManager in security-context.xml
	@Autowired
	@Qualifier("authenticationManager")
    protected AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> registerCustomer(@Valid @RequestBody UserCredentials userCredentials, BindingResult result, HttpServletRequest request) {
		UserCredentials user = userCredentialService.findOne(userCredentials.getUsername());
		if(result.hasErrors()){
			System.out.println("ERROR: Need to validation");
			List<FieldError> fieldErrors = result.getFieldErrors();
			Locale locale = LocaleContextHolder.getLocale();
			JSONObject obj = new JSONObject();
			
			for(FieldError f : fieldErrors) {
				obj.put(f.getField(), messageSource.getMessage(f, locale));
			}
			
			return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);
		}
		
		if(user != null) {
			System.out.println("A User with name "+userCredentials.getUsername()+" already exist");
			return new ResponseEntity<String>("", HttpStatus.CONFLICT);
		}
		
		userCredentialService.addCustomer(userCredentials);
		authorityService.addCustomer(userCredentials.getUsername());
		
		//After successfully Creating user
		authenticateUserAndSetSession(userCredentials, request);
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	private void authenticateUserAndSetSession(UserCredentials user, HttpServletRequest request) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		
		// Generate session if one doesn't exist
		request.getSession();
		
		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser= authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserCredentialValidator());
    }

}
