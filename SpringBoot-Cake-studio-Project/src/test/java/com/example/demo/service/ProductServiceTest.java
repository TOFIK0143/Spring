package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        this.productService = new ProductService(productRepository);
    }

    @AfterEach
    void tearDown() {
        ProductService productService = new ProductService(productRepository);
    }

    @Test
    void getAllProduct()
    {
        productService.getAllProduct();
        verify(productRepository).findAll();
    }

    @Test
    void addProduct()
    {
        Category category = new Category(55,"pestry");
        Product product = new Product(60,"apple",category,65,100,"nice","Bakery.jpeg");
        productService.addProduct(product);
        verify(productRepository).save(product);
    }

    @Test
    void removeProductById()
    {
        productService.removeProductById(1);
        verify(productRepository).deleteById(1l);
    }

    @Test
    void getProductById()
    {
        productService.getProductById(1l);
        verify(productRepository).findById(1l);
    }

    @Test
    void getAllProductByCatId()
    {
        productService.getAllProductByCatId(59);
        verify(productRepository).findAllByCategory_id(59);
    }
}