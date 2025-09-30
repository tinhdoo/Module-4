package com.shopping.service;

import com.shopping.model.Cart;
import com.shopping.model.CartItem;
import com.shopping.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService implements ICartService{
    @Override
    public Cart addItem(Cart cart, Product product, int quantity) {
        if (cart.getItems() == null) {
            cart.setItems(new ArrayList<>());
        }
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return cart;
            }
        }
        cart.getItems().add(new CartItem(product, quantity));
        return cart;
    }

    @Override
    public Cart updateItem(Cart cart, Integer productId, int quantity) {
        if (cart.getItems() == null) return cart;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(quantity);
                break;
            }
        }
        return cart;
    }

    @Override
    public Cart removeItem(Cart cart, Integer productId) {
        if (cart.getItems() != null) {
            cart.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
        }
        return cart;
    }

    @Override
    public double getTotalPrice(Cart cart) {
        if (cart.getItems() == null) return 0;
        return cart.getItems()
                .stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public int getTotalQuantity(Cart cart) {
        if (cart.getItems() == null) return 0;
        return cart.getItems()
                .stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }
}
