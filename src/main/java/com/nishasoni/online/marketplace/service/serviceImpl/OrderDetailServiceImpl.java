package com.nishasoni.online.marketplace.service.serviceImpl;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.nishasoni.online.marketplace.dao.OrderDetailDAO; 
import com.nishasoni.online.marketplace.entity.OrderDetail; 
import com.nishasoni.online.marketplace.service.OrderDetailService; 

import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService { 

@Autowired
 private OrderDetailDAO orderDetailDao;
 
 @Override 
    public List<OrderDetail> getAllOrderDetail() { 
        return orderDetailDao.findAll(); 
    } 

@Override 
  public OrderDetail loadOrderDetailById(Integer id) {
 return orderDetailDao.findById(id).orElseThrow(() -> new EntityNotFoundException("OrderDetail with ID " + id + " Not Found"));
 }

@Override 
    public OrderDetail createOrUpdateOrderDetail(OrderDetail orderDetail) {
return orderDetailDao.save(orderDetail);
   }

  @Override
 	    public void removeOrderDetail(Integer id) {
 	        orderDetailDao.deleteById(id);
 	    }

}
