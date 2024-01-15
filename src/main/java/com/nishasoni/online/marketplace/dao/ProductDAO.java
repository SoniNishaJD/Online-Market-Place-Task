package com.nishasoni.online.marketplace.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.nishasoni.online.marketplace.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> { 

} 
