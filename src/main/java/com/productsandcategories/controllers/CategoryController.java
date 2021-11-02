package com.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.productsandcategories.models.Category;
import com.productsandcategories.models.Product;
import com.productsandcategories.models.ProductAndCategories;
import com.productsandcategories.services.ProductsAndCategoriesService;

@Controller
public class CategoryController {

	private final ProductsAndCategoriesService productsAndCategoriesService;
	
	public CategoryController(ProductsAndCategoriesService productsAndCategoriesService) {
		this.productsAndCategoriesService = productsAndCategoriesService;
	}
	
	@RequestMapping("/category")
	 public String addcategory() {
	     return "addcategory.jsp";
	}
	
	@RequestMapping(value="/addingcategory", method = RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("category") Category Category, BindingResult result,
			 @RequestParam(value = "category_name") String category_name) {
		 if (result.hasErrors()) {
		     return "redirect:/category";
		 } 
		 else {
			 Category categoryData = new Category(category_name);
			 productsAndCategoriesService.createCategory(categoryData);
		     return "redirect:/category";
		 }
	}
	
	@RequestMapping("/categories/list")
	 public String showproduct(Model model) {
		
		model.addAttribute( "categoriesList", productsAndCategoriesService.allCategories() );
	    return "categorieslist.jsp";
	}
	
	@RequestMapping("/show/{category_id}")
	 public String infocategory(@PathVariable("category_id") Long category_id, Model model) {
		Category currentCategory = productsAndCategoriesService.getCategory(category_id);
		List<Product> productInfo = productsAndCategoriesService.getProductsNotLinked(currentCategory);
		List<ProductAndCategories> test = productsAndCategoriesService.getAllPCLinked();
		
		//model.addAttribute( "categoriesList", productsAndCategoriesService.getCategory(category_id) );
		System.out.println("Contain: productinfo "+ productInfo);
		model.addAttribute( "productList", productInfo );
		System.out.println("Contain: currentCategory "+ currentCategory);
		System.out.println("QQ "+ currentCategory.getProducts().size());
		System.out.println("OO "+ currentCategory.getCategory_id());
		//System.out.println("XX "+ currentCategory());
		System.out.println("JJ "+ category_id);
		System.out.println("SS "+ test);
		model.addAttribute( "categoryInfo", currentCategory );
	    return "showcategory.jsp";
	}
	
	@RequestMapping(value="/addproduct/category", method = RequestMethod.POST)
	public String addproducttocategory( @RequestParam(value = "product_id") Long product_id, @RequestParam(value = "category_id") Long category_id) {
		
		productsAndCategoriesService.linkInfo(product_id, category_id);
		return "redirect:/products";
	}
	
	
}
