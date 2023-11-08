package com.example.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.framework.Repository.CategoryRepository;
import com.example.framework.model.Category;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public void update(Category updatedCategory) {
        Optional<Category> categoryOptional = categoryRepository.findById(updatedCategory.getId());
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setId(updatedCategory.getId());
            category.setName(updatedCategory.getName());
            // Update other fields as needed
            categoryRepository.save(category);
        } else {
            // Handle category not found error
        }
    }
    
}
