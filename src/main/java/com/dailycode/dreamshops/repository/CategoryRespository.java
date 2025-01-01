package com.dailycode.dreamshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycode.dreamshops.model.Category;

public interface CategoryRespository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    boolean existsByName(String name);

}
