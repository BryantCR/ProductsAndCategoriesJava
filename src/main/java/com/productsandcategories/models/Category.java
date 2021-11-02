package com.productsandcategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="categories")
public class Category {

	// DECLARE
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	
	@NotNull
	@Size( max = 100, min = 4 )
	private String category_name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;
	
	@PrePersist
    protected void onCreate(){
        this.created_at = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updated_at = new Date();
    }
	 
	 // MANY TO MANY
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	     name = "products_categories", 
	     joinColumns = @JoinColumn(name = "category_id"), 
	     inverseJoinColumns = @JoinColumn(name = "product_id")
	 )
	 private List<Product> products;
	 
	 // CONSTRUCTORS
	 
	 public Category() {
	     // Empty constructor
	 }
	 
	 public Category( String category_name ) {
		 this.category_name = category_name;
	 }
	 
	 public Category( Long category_id, String category_name ) {
		 this.category_id = category_id;
		 this.category_name = category_name;
	 }
	 
	 public Category(Long category_id, String category_name, List<Product> products) {
		 this.category_id = category_id;
		 this.category_name = category_name;
		 this.products = products;
	 }
	 
	 // GETTERS AND SETTERS

	public Long getCategory_id() {
		return category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public List<Product> getProducts() {
		return products;
	}
	
	
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	 
	 
	 
	
}
