package com.example.ecommerce.Service.Impl;

import com.example.ecommerce.Model.Category;
import com.example.ecommerce.Repository.CategoryRepository;
import com.example.ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repo;

    @Override
    public List<Category> getAllCategories() {
        return repo.findAll();
    }
    @Override
    public Category getById(Long id){
    	return repo.findById(id).get();
    }
}
