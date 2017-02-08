package mum.edu.waa.nycsports.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> registerCustomer(@Valid @RequestBody UserCredentials userCredentials, BindingResult result) {
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

		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserCredentialValidator());
    }

}
