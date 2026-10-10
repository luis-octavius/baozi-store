package com.baozi.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baozi.store.model.Client;
import com.baozi.store.model.Order;
import com.baozi.store.model.Product;
import com.baozi.store.repository.ClientRepository;
import com.baozi.store.repository.OrderRepository;
import com.baozi.store.repository.ProductRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private final ClientRepository clientRepository;
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	
	public OrderController(
			ClientRepository clientRepository,
			OrderRepository orderRepository,
			ProductRepository productRepository) {
		this.clientRepository = clientRepository;
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}
	
	@PostMapping
	public ResponseEntity<Order> create(@RequestBody Order order) {
		Client client = order.getClient();
		Product product = order.getProduct();
		
		if (
				client == null || 
				client.getId() == null ||
				product == null || 
				product.getId() == null
			) {
			return ResponseEntity.badRequest().build();
		}
		
		Optional<Client> clientFromDb = clientRepository.findById(client.getId());
		Optional<Product> productFromDb = productRepository.findById(product.getId());
		
		if (clientFromDb.isEmpty() || productFromDb.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		order.setClient(clientFromDb.get());
		order.setProduct(productFromDb.get());
		
		var saved = orderRepository.save(order);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@GetMapping
	public List<Order> list() {
		return orderRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getById(@PathVariable Long id) {		
		return orderRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!orderRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		orderRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
