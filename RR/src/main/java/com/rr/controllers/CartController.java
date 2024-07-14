package com.rr.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rr.globaldata.GlobalData;
import com.rr.model.Product;
import com.rr.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	@Autowired
	ProductService productService;
	 
	   @GetMapping("/addToCart/{id}")
	    public String addToCart(@PathVariable int id, HttpSession session) {
	        List<Product> cart = (List<Product>) session.getAttribute("cart");
	        if (cart == null) {
	            cart = new ArrayList<>();
	            session.setAttribute("cart", cart);
	        }
	        cart.add(productService.getProductById(id).get());
	        return "redirect:/shop";
	    }
	   @GetMapping("/cart")
	    public String viewCart(Model model, HttpSession session) {
	        List<Product> cart = (List<Product>) session.getAttribute("cart");
	        if (cart == null) {
	            cart = new ArrayList<>();
	            session.setAttribute("cart", cart);
	        }
	        model.addAttribute("cart", cart);
	        model.addAttribute("cartCount", cart.size());
	        model.addAttribute("total", cart.stream().mapToDouble(Product::getPrice).sum());
	        return "cart";
	    }
}
