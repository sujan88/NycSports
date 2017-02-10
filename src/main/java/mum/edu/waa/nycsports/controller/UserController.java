package mum.edu.waa.nycsports.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String addUser(@Valid @ModelAttribute("userDetail") User user, BindingResult result, Model model, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(result.hasErrors()) {
			System.out.println("Invalidation user!");
			return "addUserDetails";
		}
		
		userService.addUser(user);
		
		//Back to wellcome page after adding new user
		RequestDispatcher rd = request.getRequestDispatcher("/welcome");
		rd.forward(request, response);
		
		return "welcome";
	}
}
