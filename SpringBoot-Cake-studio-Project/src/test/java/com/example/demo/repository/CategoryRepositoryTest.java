package com.example.demo.repository;

import com.example.demo.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryRepositoryTest
{

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void isCategory2Present()
    {
        Category category= new Category(2,"Cake");
        categoryRepository.save(category);
        boolean actualResult = categoryRepository.existsById(2);
        assertTrue(actualResult==true);

    }

    @Test
    void isCategory3Present()
    {
        Category category= new Category(3,"IceCream");
        categoryRepository.save(category);
        boolean actualResult = categoryRepository.existsById(3);
        assertTrue(actualResult==true);

    }

    @Test
    void isCategory4Present()
    {
        Category category= new Category(4,"Chocalate");
        categoryRepository.save(category);
        boolean actualResult = categoryRepository.existsById(4);
        assertTrue(actualResult==true);

    }


}