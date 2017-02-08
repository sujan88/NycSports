package mum.edu.waa.nycsports.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import mum.edu.waa.nycsports.domain.Category;
import mum.edu.waa.nycsports.domain.Product;
import mum.edu.waa.nycsports.service.CategoryService;
import mum.edu.waa.nycsports.service.ProductService;

@Controller
@RequestMapping("/admin") // map items.jsp request to ItemController class
public class AdminController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String admin() {
		return "admin/admin";
	}

	@RequestMapping("/item")
	public String items(Model model) {
		List<Product> items = productService.getAllProducts();
		model.addAttribute("items", items);
		return "admin/item";
	}

	@RequestMapping("/addItem")
	public String categories(@ModelAttribute("item") Product item, Model model) {
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("categories", categories);
		return "admin/addItem";
	}

	Path path;

	@RequestMapping(value = "/addNewItem", method = RequestMethod.POST)
	public String addItem(@Valid @ModelAttribute("item") Product item, BindingResult result, Model model,HttpServletRequest request)
			throws IllegalStateException, IOException {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			
			List<Category> categories = categoryService.getAllCategory();
			model.addAttribute("categories", categories);
			return "admin/addItem";
		}

		Category category = categoryService.getCategoryByName(item.getCategory().getName());
		

        category.addItem(item);
        item.setCategory(category);

		productService.addProduct(item);
		
		MultipartFile image = item.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\images\\" + item.getProductId() + ".png");

		if (image != null && !image.isEmpty()) {
			image.transferTo(new File(path.toString()));
		}

		return "redirect:/admin/item";
	}
	
	@RequestMapping("/editItem/{id}")
	public String editItem(@PathVariable String id, Model model) {
		
		Product item = productService.getProductById(id);
		
		model.addAttribute("item",item);
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("categories", categories);
		return "admin/editItem";
	}
	
	@RequestMapping(value = "/editItem", method = RequestMethod.POST)
	public String editItemPost( @ModelAttribute("item") Product item,BindingResult result, Model model, HttpServletRequest request) {
//		if (result.hasErrors()){
//			return "admin/editItem";
//		}
		
		
		
		MultipartFile itemImage = item.getProductImage();

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\images\\" + item.getProductId() + ".png");
		if (itemImage != null && !itemImage.isEmpty()) {

			try {
				itemImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		productService.addProduct(item);

		return "redirect:/admin/item";
	}

	@RequestMapping("/deleteItem/{id}")
	public String deleteItem(@PathVariable String id, Model model, HttpServletRequest request) {
		Product item = productService.getProductById(id);
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\images\\" + item.getProductId() + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		productService.deleteProduct(id);
		return "redirect:/admin/item";
	}
}
