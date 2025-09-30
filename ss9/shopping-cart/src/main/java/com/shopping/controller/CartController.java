package com.shopping.controller;

import com.shopping.model.Cart;
import com.shopping.model.Product;
import com.shopping.service.CartService;
import com.shopping.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }


    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", cartService.getTotalPrice(cart));
        model.addAttribute("totalQuantity", cartService.getTotalQuantity(cart));
        return "cart/view";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với id = " + id));

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        cartService.addItem(cart, product, 1);
        session.setAttribute("cart", cart);

        return "redirect:/cart/view";
    }



    @PostMapping("/update/{id}")
    public String updateCart(@PathVariable Integer id,
                             @RequestParam("quantity") int quantity,
                             HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            cartService.updateItem(cart, id, quantity);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart/view";
    }


    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Integer id, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            cartService.removeItem(cart, id);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart/view";
    }
}