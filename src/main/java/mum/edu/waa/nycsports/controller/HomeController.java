package mum.edu.waa.nycsports.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

import mum.edu.waa.nycsports.domain.Category;
import mum.edu.waa.nycsports.domain.Product;
import mum.edu.waa.nycsports.service.CategoryService;
import mum.edu.waa.nycsports.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	@Autowired  
	private HttpSession session; 
	
	@Autowired
	private CategoryService categoryService;

	@ModelAttribute("categoryList")
	public List<Category> getCategories(){
		return categoryService.getAllCategory();
	}
	@RequestMapping({"/","/welcome"})
	public String welcome(Model model, Locale locale) {

		//model.addAttribute("products", productService.getAllProducts());
		
		model.addAttribute("nProducts", productService.findProductsByDate());
		model.addAttribute("pProducts", productService.findProductsByPrice());
		
		
		System.out.printf("WELCOME AGAIN %s in %s\n","NYC Sports!",locale.getDisplayLanguage() +categoryService.getAllCategory().size());

		return "welcome";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("category")String category,Model model) {
		System.out.println(category);
		if(category.equals("all")){
			model.addAttribute("catProducts",null);
			return "forward:/welcome";
		}else{
			List<Product> p= productService.getProductsByCategory(category);
			System.out.println(p.size());
			model.addAttribute("catProducts",p);
			
		}

		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting(Model model) {
		model.addAttribute("greeting", "Welcome to NYC Sports!");
		model.addAttribute("tagline", "Make your purchasing with us and get amazing offers");
		

		return "welcome";
	}
}
