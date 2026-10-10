package com.baozi.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozi.store.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
