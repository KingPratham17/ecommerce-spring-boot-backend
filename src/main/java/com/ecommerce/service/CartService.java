package com.ecommerce.service;

import com.ecommerce.model.Cart;
import java.util.List;

public interface CartService {
    void addToCart(String email, Long productId, int quantity);
    void removeFromCart(String email, Long cartItemId);
    List<Cart> getCartItems(String email);
}
