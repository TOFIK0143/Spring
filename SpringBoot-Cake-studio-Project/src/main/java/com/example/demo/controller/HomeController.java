package com.example.demo.controller;

import com.example.demo.global.GlobalData;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	@Autowired
    CategoryService categoryService;

	@Autowired
    ProductService productService;

	@GetMapping({"/", "/home"})
	public String Home(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "index";
	}

	@GetMapping({"/shop"})
	public String Shop(Model model)
	{
		model.addAttribute("categories", categoryService.getAllcategory());
		model.addAttribute("products", productService.getAllProduct());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";

	}

	@GetMapping({"/shop/category/{id}"})
	public String ShopByCategory(Model model, @PathVariable int id )
	{
		model.addAttribute("categories", categoryService.getAllcategory());
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("products", productService.getAllProductByCatId(id));
		return "shop";

	}

	@GetMapping({"/shop/viewproduct/{id}"})
	public String viewProduct(Model model, @PathVariable int id )
	{
		model.addAttribute("product",productService.getProductById(id).get());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "viewProduct";

	}



}
