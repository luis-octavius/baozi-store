package com.baozi.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozi.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
