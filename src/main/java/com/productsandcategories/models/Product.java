package com.productsandcategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	 
	@NotNull
	@Size( max = 100, min = 4 )
	private String product_name;
	 
	@NotNull
	@Size( max = 255, min = 1 )
	private String product_description;
	
	@NotNull
	private float product_price;
	 
	@Column(updatable=false)
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
	 // MANY TO MANY RELATIONSHIP
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	     name = "products_categories", 
	     joinColumns = @JoinColumn(name = "product_id"), 
	     inverseJoinColumns = @JoinColumn(name = "category_id")
	 )
	 private List<Category> categories;
	 
	 // CONSTRUCTORS
	 
	 public Product() {
	     // EMPTY CONSTRUCTOR
	 }
	 
	 public Product( String product_name, String product_description, float product_price) {
		 this.product_name = product_name;
		 this.product_description = product_description;
		 this.product_price = product_price;
	     
	 }
	 
	 public Product(Long product_id, String product_name, String product_description, float product_price) {
		 this.product_id = product_id;
		 this.product_name = product_name;
		 this.product_description = product_description;
		 this.product_price = product_price;
	 }

	 // GETTERS
	 
	public Long getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public float getProduct_price() {
		return product_price;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	
	// SETTERS
	
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	
	// Category
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	 
	 
	
 }
