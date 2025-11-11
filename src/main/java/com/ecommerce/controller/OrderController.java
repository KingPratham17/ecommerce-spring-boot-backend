package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.security.JwtUtil;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/checkout")
    public String checkout(@RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractEmail(token.substring(7));
        orderService.checkout(email);
        return "Order placed successfully!";
    }

    @GetMapping
    public List<Order> getOrders(@RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractEmail(token.substring(7));
        return orderService.getOrders(email);
    }
}
