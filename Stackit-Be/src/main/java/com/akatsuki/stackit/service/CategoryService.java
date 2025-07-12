package com.akatsuki.stackit.service;

import com.akatsuki.stackit.domain.dto.UpdateCategoryRequest;
import com.akatsuki.stackit.domain.entities.Category;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category getCategoryById(UUID id);
    List<Category> listCategories();
    Category createCategory(Category category);
    Category updateCategory(UUID id, @Valid UpdateCategoryRequest updateCategoryRequest);
    void deleteCategory(UUID id);
}
