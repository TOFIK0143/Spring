package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
   private CategoryRepository categoryRepository;

   private CategoryService categoryService;

   //AutoCloseable autoCloseable;
    @BeforeEach
    void setUp()
    {
       // AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this);
        this.categoryService = new CategoryService(categoryRepository);
    }

    @AfterEach
    void tearDown() {
//        try {
//            this.autoCloseable.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        this.categoryService= new CategoryService(this.categoryRepository);
    }

    @Test
    void getAllcategory()
    {
        categoryService.getAllcategory();
        verify(categoryRepository).findAll();
    }

    @Test
    void addCategory()
    {
        Category category = new Category(6,"puff");
        categoryRepository.save(category);
        verify(categoryRepository).save(category);
    }

    @Test
    void removeCategoryById()
    {
        categoryRepository.deleteById(1);
        verify(categoryRepository).deleteById(1);
    }

    @Test
    void getCategoryById()
    {
        categoryService.getCategoryById(1);
        verify(categoryRepository).findById(1);
    }
}