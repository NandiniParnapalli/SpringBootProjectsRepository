package com.prod.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.user.entity.ProductInfo;

import com.prod.user.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to the product management";
	}
	
	@PostMapping("/addProduct")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addProduct(@RequestBody ProductInfo productInfo) {
		return productService.addProduct(productInfo);
		 
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ProductInfo getProductById(@PathVariable Integer id) {
		
		return productService.getProductById(id);
	}
	@GetMapping("/getall")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public List<ProductInfo> getAllProduct() {
		
		return productService.getAllProduct();
	}

}
