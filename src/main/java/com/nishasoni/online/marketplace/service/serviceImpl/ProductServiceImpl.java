package com.nishasoni.online.marketplace.service.serviceImpl;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.nishasoni.online.marketplace.dao.ProductDAO; 
import com.nishasoni.online.marketplace.entity.Product; 
import com.nishasoni.online.marketplace.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService { 

@Autowired
 private ProductDAO productDao;
 
 @Override 
    public List<Product> getAllProduct() { 
        return productDao.findAll(); 
    } 

@Override 
  public Product loadProductById(Integer id) {
 return productDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Product with ID " + id + " Not Found"));
 }

@Override 
    public Product createOrUpdateProduct(Product product) {
return productDao.save(product);
   }

  @Override
 	    public void removeProduct(Integer id) {
 	        productDao.deleteById(id);
 	    }

}
