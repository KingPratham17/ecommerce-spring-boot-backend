package com.ecommerce.controller;

import com.ecommerce.model.Cart;
import com.ecommerce.service.CartService;
import com.ecommerce.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/add")
    public String addToCart(@RequestHeader("Authorization") String token,
                            @RequestParam Long productId,
                            @RequestParam int quantity) {
        String email = jwtUtil.extractEmail(token.substring(7));
        cartService.addToCart(email, productId, quantity);
        return "Product added to cart";
    }

    @DeleteMapping("/remove/{id}")
    public String removeFromCart(@RequestHeader("Authorization") String token,
                                 @PathVariable Long id) {
        String email = jwtUtil.extractEmail(token.substring(7));
        cartService.removeFromCart(email, id);
        return "Product removed from cart";
    }

    @GetMapping
    public List<Cart> getCartItems(@RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractEmail(token.substring(7));
        return cartService.getCartItems(email);
    }
}
