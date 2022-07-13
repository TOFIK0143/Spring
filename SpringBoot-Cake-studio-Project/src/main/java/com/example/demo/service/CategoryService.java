package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository ;

    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository=categoryRepository;
    }


    //Read all data
    public List<Category> getAllcategory()
    {
        return this.categoryRepository.findAll();
    }

    //create
    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }

    //delete
    public void removeCategoryById(int id)
    {
    categoryRepository.deleteById(id);
    }

    //fetch item of category by id
    //
    public Optional<Category> getCategoryById(int id)
    {
		return categoryRepository.findById(id);
    	
    }
}
