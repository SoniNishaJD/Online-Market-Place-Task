package com.nishasoni.online.marketplace.service;

import com.nishasoni.online.marketplace.entity.OrderDetail;
import java.util.List;

public interface OrderDetailService { 

  List<OrderDetail> getAllOrderDetail();

   OrderDetail loadOrderDetailById(Integer id );

   OrderDetail createOrUpdateOrderDetail(OrderDetail orderDetail);

   void removeOrderDetail(Integer id);

} 
