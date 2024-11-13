package sit.int202.classicmodels_2567.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sit.int202.classicmodels_2567.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("")
    public String getProducts(Model model){
        model.addAttribute("products", service.getAllProducts());
        model.addAttribute("page", "products");
        return "product_list";
    }
}
