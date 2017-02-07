package mum.edu.waa.nycsports.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import mum.edu.waa.nycsports.domain.Category;
import mum.edu.waa.nycsports.domain.Product;


public interface CategoryService {

	List<Category> getAllCategory();

	Category getCategoryByName(String categoryName);
	

	void addCategory(Category category);
}
