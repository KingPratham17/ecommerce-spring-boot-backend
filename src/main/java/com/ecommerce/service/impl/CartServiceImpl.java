package com.ecommerce.service.impl;

import com.ecommerce.model.*;
import com.ecommerce.repository.*;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addToCart(String email, Long productId, int quantity) {
        User user = userRepository.findByEmail(email).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();

        Cart cart = Cart.builder()
                .user(user)
                .product(product)
                .quantity(quantity)
                .build();

        cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(String email, Long cartItemId) {
        Cart cart = cartRepository.findById(cartItemId).orElseThrow();
        if (!cart.getUser().getEmail().equals(email)) {
            throw new RuntimeException("Unauthorized access to cart item");
        }
        cartRepository.delete(cart);
    }

    @Override
    public List<Cart> getCartItems(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return cartRepository.findByUser(user);
    }
}
