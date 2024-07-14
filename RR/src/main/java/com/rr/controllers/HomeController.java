package com.rr.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rr.globaldata.GlobalData;
import com.rr.model.Product;
import com.rr.service.CategoryService;
import com.rr.service.ProductService;

@Controller
public class HomeController {
	@Autowired
 CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		 model.addAttribute("cartCount",GlobalData.cart.size());
		return "index";
	}
	@GetMapping("/shop")
	public String shop(Model model) {
		 model.addAttribute("cartCount",GlobalData.cart.size());
		model.addAttribute( "categories", categoryService.getAllCategory());
		model.addAttribute( "products", productService.getAllProducts());
		return "shop";
	}
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id) {
		 model.addAttribute("cartCount",GlobalData.cart.size());
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("products", productService.getAllProductsByCategoryId(id));
		return "shop";
	}
	

	@GetMapping("/shop/viewproduct/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
		 model.addAttribute("cartCount",GlobalData.cart.size());
        Optional<Product> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            model.addAttribute("product", product);
            return "viewProduct";
        } else {
            // Handle the case when the product is not found
            return "productNotFound";
        }
	}

	
}
