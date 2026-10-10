package com.baozi.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baozi.store.model.Product;
import com.baozi.store.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductRepository repository;
	
	public ProductController(ProductRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product saved = repository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@GetMapping 
	public List<Product> list() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id) {
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
