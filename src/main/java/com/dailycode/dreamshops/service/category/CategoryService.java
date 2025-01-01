package com.dailycode.dreamshops.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dailycode.dreamshops.exceptions.AlreadyExistException;
import com.dailycode.dreamshops.exceptions.ResourceNotFoundException;
import com.dailycode.dreamshops.model.Category;
import com.dailycode.dreamshops.repository.CategoryRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRespository categoryRespository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRespository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRespository.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRespository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
       return Optional.of(category).filter(c -> !categoryRespository.existsByName(c.getName()))
       .map(categoryRespository::save)
       .orElseThrow(() -> new AlreadyExistException(category.getName()+" already exist"));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id)).map(oldCategory -> {
            oldCategory.setName(category.getName());
            return categoryRespository.save(oldCategory);
        }).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRespository.findById(id)
        .ifPresentOrElse(categoryRespository::delete, () -> {
            throw new ResourceNotFoundException("Category not found");
        });
    }

}
