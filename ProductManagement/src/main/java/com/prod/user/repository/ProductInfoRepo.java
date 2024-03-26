package com.prod.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.user.entity.ProductInfo;
@Repository
public interface ProductInfoRepo extends JpaRepository<ProductInfo, Integer>{

}
