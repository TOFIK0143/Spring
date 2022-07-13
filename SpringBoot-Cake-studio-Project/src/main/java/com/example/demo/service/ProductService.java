package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
    ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}

	public List<Product> getAllProduct()
	    {
	        return productRepository.findAll()  ;
	    }
	 public void addProduct(Product product)
	 {
		 productRepository.save(product);
	 }


	 public void removeProductById(long id)
	 {
		 productRepository.deleteById(id);
	 }

	 public Optional<Product> getProductById(long id)
	 {
		return productRepository.findById(id);

	 }
	 public List<Product> getAllProductByCatId(int id)
	 {
		return productRepository.findAllByCategory_id(id);

	 }

}
