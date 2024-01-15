package com.nishasoni.online.marketplace.controller;

import com.nishasoni.online.marketplace.entity.OrderDetail; 
import com.nishasoni.online.marketplace.service.ProductService; 
import com.nishasoni.online.marketplace.entity.Product; 
import com.nishasoni.online.marketplace.service.OrderDetailService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List; 

import com.nishasoni.online.marketplace.util.Helper;
@Controller 
@RequestMapping(value = "admin/orderDetail") 
public class OrderDetailController { 
 private OrderDetailService orderDetailService; 
 private ProductService productService; 
    public OrderDetailController(OrderDetailService orderDetailService,ProductService productService ) { 
        this.orderDetailService = orderDetailService; 
        this.productService = productService; 
    }
 
    @GetMapping(value = "/index") 
    public String orderDetails(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetail(); 
        model.addAttribute("listOrderDetails", orderDetails); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/orderDetails_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formOrderDetails(Model model) {
        model.addAttribute("orderDetail", new OrderDetail()); 
List<Product> products = productService.getAllProduct(); 
model.addAttribute("listProducts", products); 

        return "admin/entry/orderDetail_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteOrderDetail(@PathVariable(value = "id") Integer id, String keyword, HttpSession session) {
        orderDetailService.removeOrderDetail(id); 
        return "redirect:/admin/orderDetail/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateOrderDetail(@PathVariable(value = "id") Integer id, Model model) {
        OrderDetail orderDetail = orderDetailService.loadOrderDetailById(id); 
        model.addAttribute("orderDetail", orderDetail); 
List<Product> products = productService.getAllProduct(); 
model.addAttribute("listProducts", products); 

        return "admin/edit/orderDetail_edit"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(OrderDetail orderDetail,  HttpSession session) { 
       String msg = "inserted";
		if(orderDetail.getId() != null && orderDetail.getId() != 0) {
			msg = "updated";
		}
		OrderDetail obj = orderDetailService.createOrUpdateOrderDetail(orderDetail);
		if(obj != null) {
			session.setAttribute("msg", "inserted");
		}else {
			session.setAttribute("error","error");
		}
		return "redirect:/admin/orderDetail/index";
    }
 
} 
