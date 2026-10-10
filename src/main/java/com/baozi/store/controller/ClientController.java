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

import com.baozi.store.model.Client;
import com.baozi.store.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {
	private final ClientRepository repository;
	
	public ClientController(ClientRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<Client> create(@RequestBody Client client) {
		var saved = repository.save(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@GetMapping
	public List<Client> list() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getById(@PathVariable Long id) {
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
