package mum.edu.waa.nycsports.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import mum.edu.waa.nycsports.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	@Autowired  
	private HttpSession session; 
	

	@RequestMapping({"/","/welcome"})
	public String welcome(Model model, Locale locale) {

		//model.addAttribute("products", productService.getAllProducts());
		
		model.addAttribute("nProducts", productService.findProductsByDate());
		
		model.addAttribute("pProducts", productService.findProductsByPrice());
		
		
  		
		System.out.printf("WELCOME AGAIN %s in %s\n","NYC Sports!",locale.getDisplayLanguage());

		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting(Model model) {
		model.addAttribute("greeting", "Welcome to NYC Sports!");
		model.addAttribute("tagline", "Make your purchasing with us and get amazing offers");
		

		return "welcome";
	}
}
