package com.nishasoni.online.marketplace.controller;

import com.nishasoni.online.marketplace.entity.Product; 
import com.nishasoni.online.marketplace.service.ProductService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.util.StringUtils;
import com.nishasoni.online.marketplace.util.FileUploadUtil;
import org.springframework.web.multipart.MultipartFile;

import java.util.List; 

import com.nishasoni.online.marketplace.util.Helper;
@Controller 
@RequestMapping(value = "admin/product") 
public class ProductController { 
 private ProductService productService; 
    public ProductController(ProductService productService) { 
        this.productService = productService; 
    }
 
    @GetMapping(value = "/index") 
    public String products(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<Product> products = productService.getAllProduct(); 
        model.addAttribute("listProducts", products); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/products_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formProducts(Model model) {
        model.addAttribute("product", new Product()); 
        return "admin/entry/product_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteProduct(@PathVariable(value = "id") Integer id, String keyword, HttpSession session) {
        productService.removeProduct(id); 
        return "redirect:/admin/product/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateProduct(@PathVariable(value = "id") Integer id, Model model) {
        Product product = productService.loadProductById(id); 
        model.addAttribute("product", product); 
        return "admin/edit/product_edit"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(Product product, @RequestParam("fileImage") MultipartFile fileImage, HttpSession session)  throws IOException {
       String msg = "inserted";
		if(product.getId() != null && product.getId() != 0) {
			msg = "updated";
		}
     String fileImageTime = new SimpleDateFormat("yyyyMMddHHmmssms").format(new Date());
		String fileImageName = StringUtils.cleanPath(fileImage.getOriginalFilename());
		if (fileImageName.length() > 3) {
			fileImageName = fileImageTime+fileImageName;
			product.setImage(fileImageName);
			String uploadDir = "assets1/images/product";
			FileUploadUtil.saveFile(uploadDir, fileImageName, fileImage);
		}else {
    		if(product.getId() ==null) {
    			product.setImage("no-img.png");
    		}
    	}
		Product obj = productService.createOrUpdateProduct(product);
		if(obj != null) {
			session.setAttribute("msg", "inserted");
		}else {
			session.setAttribute("error","error");
		}
		return "redirect:/admin/product/index";
    }
 
} 
