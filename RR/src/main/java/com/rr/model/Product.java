package com.rr.model;

import jakarta.persistence.*;
import lombok.Data;
import com.rr.model.Category;
@Entity
@Data

public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Category category;
	private Double price;
	private Double weight;
	private String description;
	private String imageName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
