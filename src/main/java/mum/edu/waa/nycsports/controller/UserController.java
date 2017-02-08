package mum.edu.waa.nycsports.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.waa.nycsports.domain.User;
import mum.edu.waa.nycsports.formatter.UserConverter;
import mum.edu.waa.nycsports.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value="/addUserDetails", method=RequestMethod.GET)
	public String addUserDetailsForm() {
		return "addUserDetails";
	}
	
	@RequestMapping(value="/addUserDetails", method=RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody String text, BindingResult result, HttpServletRequest request) {        
		UserConverter userConverter = new UserConverter();
		User user = userConverter.convert(text);
		
		if(result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			Locale locale = LocaleContextHolder.getLocale();
			JSONObject obj = new JSONObject();
			
			for(FieldError f : fieldErrors) {
				obj.put(f.getField(), messageSource.getMessage(f, locale));
			}
			
			return new ResponseEntity<String>(obj.toString(), HttpStatus.BAD_REQUEST);
		}
		
		userService.addUser(user);
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
}
