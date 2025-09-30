package com.shopping.service;

import com.shopping.model.Cart;
import com.shopping.model.Product;

public interface ICartService {
    Cart addItem(Cart cart, Product product, int quantity);

    Cart updateItem(Cart cart, Integer productId, int quantity);

    Cart removeItem(Cart cart, Integer productId);

    double getTotalPrice(Cart cart);

    int getTotalQuantity(Cart cart);
}
