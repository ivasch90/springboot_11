package ru.gb.springboot_1.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gb.springboot_1.model.Product;
import ru.gb.springboot_1.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

        @GetMapping("/products/create")
        public String ShowForm (Model model) {
            Product product = new Product();
            model.addAttribute("product", product);
            return "create-product";

        }

        @PostMapping("/products/create")
        public String processForm(Product product) {
            if (product.getId() == null) {
                productService.save(product);
            }
            return "redirect:/products/all";
        }

        @GetMapping("/products/all")
        public String getAllProduct(Model model) {
            model.addAttribute("productList", productService.findAll());
            return "products";
        }
}
