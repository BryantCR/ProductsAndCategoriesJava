package com.productsandcategories.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productsandcategories.models.ProductAndCategories;

@Repository
public interface ProductsAndCategoriesRepository extends CrudRepository< ProductAndCategories, Long>{
	@Modifying
	@Transactional
	@Query( value="SELECT b.name, b.pages, a.firstname, a.lastname " +
			  "FROM authors a JOIN authors_books ab ON a.author_id = ab.author_id " +
			  			     "JOIN books b ON b.book_id = ab.book_id", nativeQuery=true )
	
	List<Object[]> selectProductsAndCategories2();
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO products_categories (product_id, category_id)  VALUE (?1, ?2) ", nativeQuery=true)
	void insertProductToCategory(Long product_id, Long category_id);
	
	@Modifying
	@Transactional
	@Query(value="Select product_id, product_name, category_id, category_name from products_categories pc left join categories c ON pc.categories_id = c.category_id left join products p ON p.product_id = pc.products_id;", nativeQuery=true)
	List<ProductAndCategories> selectProductsAndCategories();
	
	@Modifying
	@Transactional
	@Query(value="Select * from products_categories pc left join products p ON p.product_id = pc.product_id", nativeQuery=true)
	List<ProductAndCategories> selectProductsAndCategoriesLinked();
}
