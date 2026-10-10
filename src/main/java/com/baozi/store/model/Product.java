package com.baozi.store.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String name;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal price; 
	
	private boolean stock; 
	
	public Product() {}
	
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
	
	public BigDecimal getPrice() { 
		return price; 
	}
	
	public void setPrice(BigDecimal price) { 
		this.price = price; 
	}
	
	public Boolean getStock() { 
		return stock; 
	}
	
	public void setStock(boolean stock) { 
		this.stock = stock; 
	}
}

