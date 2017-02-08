																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																													package mum.edu.waa.nycsports.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.waa.nycsports.domain.Category;
import mum.edu.waa.nycsports.domain.Product;
import mum.edu.waa.nycsports.repository.CategoryRepository;
import mum.edu.waa.nycsports.repository.ProductRepository;
import mum.edu.waa.nycsports.service.CategoryService;
import mum.edu.waa.nycsports.service.ProductService;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return (List<Category>)categoryRepository.findAll();
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		
		return categoryRepository.findOne(categoryName);
	}

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
		
	}

	
}
