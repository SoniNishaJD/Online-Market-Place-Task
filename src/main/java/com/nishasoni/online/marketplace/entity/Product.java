package com.nishasoni.online.marketplace.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="product")
public class Product{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="image", nullable = false , length = 255)
private String image;

@Basic
@Column(name="mrp", nullable = false )
private Float mrp;

@Basic
@Column(name="name", nullable = false , length = 45)
private String name;

@Basic
@Column(name="product_description", nullable = false , length = 455)
private String productDescription;

@Basic
@Column(name="sales_price", nullable = false )
private Float salesPrice;

@Basic
@Column(name="status", nullable = false )
private Integer status;

@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
private Set<OrderDetail> orderDetail = new HashSet<>();

public Integer getId() { 
	return id; 
} 

public void setId(Integer id) {
	this.id = id;
}
public String getImage() { 
	return image; 
} 

public void setImage(String image) {
	this.image = image;
}
public Float getMrp() { 
	return mrp; 
} 

public void setMrp(Float mrp) {
	this.mrp = mrp;
}
public String getName() { 
	return name; 
} 

public void setName(String name) {
	this.name = name;
}
public String getProductDescription() { 
	return productDescription; 
} 

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public Float getSalesPrice() { 
	return salesPrice; 
} 

public void setSalesPrice(Float salesPrice) {
	this.salesPrice = salesPrice;
}
public Integer getStatus() { 
	return status; 
} 

public void setStatus(Integer status) {
	this.status = status;
}
public Set<OrderDetail> getOrderDetails() { 
	return orderDetail; 
} 

public void setOrderDetails(Set<OrderDetail> orderDetail) {
	this.orderDetail = orderDetail;
}
  @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(image, other.image)   &&   Objects.equals(mrp, other.mrp)   &&   Objects.equals(name, other.name)   &&   Objects.equals(productDescription, other.productDescription)   &&   Objects.equals(salesPrice, other.salesPrice)   &&   Objects.equals(status, other.status)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, image, mrp, name, productDescription, salesPrice, status);
     }
public Product() { 
super();
 }
public Product(String image, Float mrp, String name, String productDescription, Float salesPrice, Integer status ){
 super();
 this.image = image; 
this.mrp = mrp; 
this.name = name; 
this.productDescription = productDescription; 
this.salesPrice = salesPrice; 
this.status = status; 
}
@Override 
public String toString() {
return "Product [id=" + id + ", image=" + image + ", mrp=" + mrp + ", name=" + name + ", productDescription=" + productDescription + ", salesPrice=" + salesPrice + ", status=" + status + "]" ; 
 } 
   @Transient
    public String getImagePathImage() {
        if (image == null )
            return null;
        return "/assets1/images/product/" + image;
    }
}
