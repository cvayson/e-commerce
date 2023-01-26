package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Category;
import com.example.ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/get")
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }
  
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/get/{id}")
    public Category getById(@PathVariable Long id){
    	return service.getById(id);
    }
	
}
