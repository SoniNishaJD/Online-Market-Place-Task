package com.nishasoni.online.marketplace.entity;



import java.util.HashSet;
import java.util.Objects;


import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="order_detail")
public class OrderDetail{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="mrp", nullable = false )
private Float mrp;

@Basic
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@Column(name="order_date", nullable = true)
private Date orderDate;

@Basic
@Column(name="price", nullable = false )
private Float price;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "product_id",referencedColumnName = "id",nullable = false)
private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
	private User user;

@Basic
@Column(name="qty", nullable = false )
private Integer qty;


////////////////////////////////////////////////////

public Integer getId() { 
	return id; 
} 

public void setId(Integer id) {
	this.id = id;
}
public Float getMrp() { 
	return mrp; 
} 

public void setMrp(Float mrp) {
	this.mrp = mrp;
}
public Date getOrderDate() { 
	return orderDate; 
} 

public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public Float getPrice() { 
	return price; 
} 

public void setPrice(Float price) {
	this.price = price;
}
public Integer getQty() { 
	return qty; 
} 

public void setQty(Integer qty) {
	this.qty = qty;
}

public Product getProduct() { 
	return product; 
} 

public void setProduct(Product product) {
	this.product = product;
}
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
  @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
        OrderDetail other = (OrderDetail) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(mrp, other.mrp)   &&   Objects.equals(orderDate, other.orderDate)   &&   Objects.equals(price, other.price)   &&   Objects.equals(qty, other.qty)    ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, mrp, orderDate, price, qty);
     }
public OrderDetail() { 
super();
 }
public OrderDetail(Float mrp, Date orderDate, Float price, Integer qty, Product product,User user ){
 super();
 this.mrp = mrp; 
this.orderDate = orderDate; 
this.price = price; 
this.qty = qty; 
this.product = product;
this.user = user;
}
@Override 
public String toString() {
return "OrderDetail [id=" + id + ", mrp=" + mrp + ", orderDate=" + orderDate + ", price=" + price + ", qty=" + qty + "]" ;
 } 
}
