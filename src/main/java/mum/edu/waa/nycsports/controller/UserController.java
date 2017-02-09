package mum.edu.waa.nycsports.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mum.edu.waa.nycsports.domain.User;
import mum.edu.waa.nycsports.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addUserDetails", method=RequestMethod.GET)
	public String addUserDetailsForm(@ModelAttribute("userDetail") User user, Model model) {
		return "addUserDetails";
	} 
	
	@RequestMapping(value="/addUserDetails", method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("userDetail") User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println("Invalidation user!");
			return "addUserDetails";
		}
		
		userService.addUser(user);
		
		return "welcome";
	}
}
