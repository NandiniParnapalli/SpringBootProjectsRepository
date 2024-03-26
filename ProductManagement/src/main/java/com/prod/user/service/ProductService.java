
package com.prod.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prod.user.entity.ProductInfo;
import com.prod.user.repository.ProductInfoRepo;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductInfoRepo productInfoRepo;

    public String addProduct(ProductInfo productInfo) {
        try {
            productInfoRepo.save(productInfo);
            return "Product added successfully";
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            e.printStackTrace();
            return "Failed to add product";
        }
    }

    public ProductInfo getProductById(Integer id) {
        return productInfoRepo.findById(id).orElse(null);
    }

    public List<ProductInfo> getAllProduct() {
        return productInfoRepo.findAll();
    }
}

