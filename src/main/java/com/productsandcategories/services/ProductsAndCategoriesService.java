package com.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productsandcategories.models.Category;
import com.productsandcategories.models.Product;
import com.productsandcategories.models.ProductAndCategories;
import com.productsandcategories.repositories.CategoryRepository;
import com.productsandcategories.repositories.ProductRepository;
import com.productsandcategories.repositories.ProductsAndCategoriesRepository;


@Service
public class ProductsAndCategoriesService {
	
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final ProductsAndCategoriesRepository productsAndCategoriesRepository;
	
    public ProductsAndCategoriesService(CategoryRepository categoryRepository, ProductRepository productRepository, ProductsAndCategoriesRepository productsAndCategoriesRepository) {
    	this.categoryRepository = categoryRepository;
    	this.productRepository = productRepository;
    	this.productsAndCategoriesRepository = productsAndCategoriesRepository;
    }
    
    // Category
    
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
	
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    public Category findCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            return category.get();
        } else {
            return null;
        }
    }
    
    public Category getCategory(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
    
    public List<Category> getCategoriesNotLinked(Product product) {
    	return categoryRepository.findByProductsNotContains(product);
    }
    
    // Product
    
	public List<Product> allProducts() {
        return productRepository.findAll();
    }
	
	public Product createProduct(Product product) {
        return productRepository.save(product);
    }
	
	public Product findProduct(Long product_id) {
        Optional<Product> product = productRepository.findById(product_id);
        if(product.isPresent()) {
            return product.get();
        } else {
            return null;
        }
    }
	
	public List<Product> getProductsNotLinked(Category category) {
    	return productRepository.findByCategoriesNotContains(category);
    }
	
	// Both
	
	public void linkInfo(Long product_id, Long category_id) {
		productsAndCategoriesRepository.insertProductToCategory(product_id, category_id);
	}
	
	public void linkInfo2(Long product_id, Long category_id) {
		productsAndCategoriesRepository.insertProductToCategory(product_id, category_id);
	}
	
	public List<ProductAndCategories> allCategoriesAndProducts() {
        return productsAndCategoriesRepository.selectProductsAndCategories();
    }
	
	public List<ProductAndCategories> getAllPCLinked(){
		return productsAndCategoriesRepository.selectProductsAndCategoriesLinked();
	}
	
	
}
