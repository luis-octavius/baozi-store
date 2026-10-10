package com.baozi.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozi.store.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
