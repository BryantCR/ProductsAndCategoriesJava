package com.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productsandcategories.models.Category;
import com.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository< Product, Long>{

	//Product save( Product product );
	void deleteById(Long id);
	List<Product> findAll();
	Optional <Product> findById(Long id);
	List<Product> findByCategoriesNotContains(Category category);
	
	//List<Category> findByProductsNotContains(Product product);
	//List<Category> findAllByProducts(Product product);
}
