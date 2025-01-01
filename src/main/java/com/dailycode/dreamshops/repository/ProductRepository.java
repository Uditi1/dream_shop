package com.dailycode.dreamshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycode.dreamshops.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
