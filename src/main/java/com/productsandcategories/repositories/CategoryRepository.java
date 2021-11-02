package com.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productsandcategories.models.Category;
import com.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository< Category, Long>{
	
	//Category save( Category category );
	void deleteById(Long id);
	List<Category> findAll();
	Optional <Category> findById(Long id);
	List<Category> findByProductsNotContains(Product product);
	List<Category> findAllByProducts(Product product);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO categories (category) " + "VALUES(?1)", nativeQuery=true)
	void insertNewCategory(String name);
	
}
