package com.shopping.controller;

import com.shopping.exception.ProductNotFound;
import com.shopping.model.Cart;
import com.shopping.model.Product;
import com.shopping.repository.IProductRepository;
import com.shopping.service.IProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    private final IProductRepository productRepository;

    public ProductController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id, HttpSession session) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Không tìm thấy sản phẩm id=" + id));


        Map<Long, Integer> cart = Optional.ofNullable(session.getAttribute("cart"))
                .filter(obj -> obj instanceof Map)
                .map(obj -> (Map<Long, Integer>) obj)
                .orElse(new HashMap<>());


        cart.put(id, cart.getOrDefault(id, 0) + 1);


        session.setAttribute("cart", cart);

        return "redirect:/cart/view";
    }

}
