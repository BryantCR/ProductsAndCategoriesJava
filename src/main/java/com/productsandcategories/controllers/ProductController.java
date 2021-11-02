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
import com.productsandcategories.services.ProductsAndCategoriesService;

@Controller
public class ProductController {
	
	private final ProductsAndCategoriesService productsAndCategoriesService;
	
	public ProductController(ProductsAndCategoriesService productsAndCategoriesService) {
		this.productsAndCategoriesService = productsAndCategoriesService;
	}
	
	@RequestMapping("/products")
	 public String addproduct() {
	     return "addproduct.jsp";
	}
	
	@RequestMapping(value="/adding", method = RequestMethod.POST)
	
	 public String create(@Valid @ModelAttribute("product") Product product, BindingResult result,
			 @RequestParam(value = "product_name") String product_name,
			 @RequestParam(value = "product_description") String product_description,
			 @RequestParam(value = "product_price") float product_price) {
		 if (result.hasErrors()) {
		     return "redirect:/products";
		 } 
		 else {
			 Product productData = new Product(product_name, product_description, product_price);
			 productsAndCategoriesService.createProduct(productData);
		     return "redirect:/products";
		 }
	}
	
	@RequestMapping("/showproducts")
	 public String showproduct(Model model) {
		model.addAttribute( "productsList", productsAndCategoriesService.allProducts() );
	    return "productlist.jsp";
	}
	
	@RequestMapping("/info/{product_id}")
	 public String infocategory(@PathVariable("product_id") Long product_id, Model model) {
		Product currentProduct = productsAndCategoriesService.findProduct(product_id);
		List<Category> categoryInfo = productsAndCategoriesService.getCategoriesNotLinked(currentProduct);
		
		//model.addAttribute( "productsList", productsAndCategoriesService.findProduct(product_id) );
		System.out.println("Contain: productinfo "+ categoryInfo);
		model.addAttribute( "CategoryList", categoryInfo );
		System.out.println("Contain: currentCategory "+ currentProduct);
		model.addAttribute( "productInfo", currentProduct );
	    return "showproduct.jsp";
	}
	
	@RequestMapping(value="/addcategory/product", method = RequestMethod.POST)
	public String addproducttocategory( @RequestParam(value = "product_id") Long product_id, @RequestParam(value = "category_id") Long category_id) {
		
		productsAndCategoriesService.linkInfo(product_id, category_id);
		return "redirect:/products";
	}
	
	//Product currentProduct = productsAndCategoriesService.findProduct(category_id);
	//List<Category> categoryInfo = productsAndCategoriesService.getCategoriesNotLinked(null);

}
