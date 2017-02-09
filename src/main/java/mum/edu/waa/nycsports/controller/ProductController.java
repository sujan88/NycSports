package mum.edu.waa.nycsports.controller;

import java.io.File;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.waa.nycsports.domain.Cart;
import mum.edu.waa.nycsports.domain.Product;
import mum.edu.waa.nycsports.exception.NoProductsFoundUnderCategoryException;
import mum.edu.waa.nycsports.exception.ProductNotFoundException;
import mum.edu.waa.nycsports.service.CartService;
import mum.edu.waa.nycsports.service.ProductService;



@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
		@Autowired
		private CartService cartService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());

		Locale locale = LocaleContextHolder.getLocale();
		System.out.printf("WELCOME AGAIN %s in %s\n","Kemosabe!",locale.getDisplayLanguage());

		return "products";
	}
	
	@RequestMapping("/all")
	public ModelAndView allProducts() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String category) {
		List<Product> products = productService.getProductsByCategory(category);

		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}

		model.addAttribute("products", products);
		return "products";
	}

	
 	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") String productId) {
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "product";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
	   return "addProduct";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct")  Product newProduct, BindingResult result, HttpServletRequest request) {
	System.out.println("EEERRRRR");
		if(result.hasErrors()) {
			return "addProduct";
		}

		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			
		//isEmpty means file exists BUT NO Content
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
		      	productImage.transferTo(new File(rootDirectory+"\\resources\\images\\"+newProduct.getProductId() + ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }

	   	productService.addProduct(newProduct);
		return "redirect:/products";
	}
	
	@RequestMapping(value = "/throw", method = RequestMethod.GET)
	public String throwException(@ModelAttribute("newProduct") Product newProduct) {
	

	String productId = "B1234";
	Product product = productService.getProductById(productId);
	if(product == null) {
		throw new ProductNotFoundException(productId, null);
	}
	return "";
}


	@RequestMapping(value = "/cartmini", method = RequestMethod.GET)
	public String getCart( Model model,HttpServletRequest request) {
			System.out.println(request.getSession(true).getId()+" PPPPP ");
		model.addAttribute("cartId",request.getSession(true).getId());
		Cart cart = cartService.read(request.getSession(true).getId());
		if (cart == null) {
			cart = new Cart(request.getSession(true).getId());
			cartService.create(cart );
		}
		model.addAttribute("cart",cart);
		
		return "product";
	}
	
	
	// Either this Method HERE ...OR remove and put it in ControllerAdvice class
/*
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("invalidProductId", exception.getFullMessage());
		 mav.setViewName("productNotFound");
		 return mav;
	}
	*/


}
