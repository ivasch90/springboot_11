package ru.gb.springboot_1.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.springboot_1.entity.Product;
import ru.gb.springboot_1.service.ProductService;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/create")
    public String ShowForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";

    }

    @PostMapping("/products/create")
    public String processForm(Product product) {
        if (product.getId() == null) {
            product.setDate(LocalDate.now());
            product.setMan_id(1L);
            productService.save(product);
        }
        return "redirect:/products/all";
    }

    @GetMapping("/products/all")
    public String getAllProduct(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "products";
    }

    @GetMapping(path = "/products/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping(path = "/products/delete")
    public String deleteById(@RequestParam Long id) {

        productService.deleteById(id);
        return "redirect:/products/all";
    }
}
