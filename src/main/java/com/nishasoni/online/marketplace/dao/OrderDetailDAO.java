package com.nishasoni.online.marketplace.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.nishasoni.online.marketplace.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> { 

} 
