package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();
    public Category getById(Long id);
}
