package com.nishasoni.online.marketplace.service;

import com.nishasoni.online.marketplace.entity.Product;
import java.util.List;

public interface ProductService { 

  List<Product> getAllProduct();

   Product loadProductById(Integer id );

   Product createOrUpdateProduct(Product product);

   void removeProduct(Integer id);

} 
