package com.ecommerce.service.impl;

import com.ecommerce.model.*;
import com.ecommerce.repository.*;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void checkout(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();

        List<Cart> cartItems = cartRepository.findByUser(user);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        for (Cart cart : cartItems) {
            Product product = cart.getProduct();
            int qty = cart.getQuantity();

            if (product.getQuantity() < qty) {
                throw new RuntimeException("Not enough stock for: " + product.getName());
            }

            // Reduce stock
            product.setQuantity(product.getQuantity() - qty);
            productRepository.save(product);

            OrderItem item = OrderItem.builder()
                    .product(product)
                    .quantity(qty)
                    .price(product.getPrice())
                    .build();

            orderItems.add(item);
            total += product.getPrice() * qty;
        }

        Order order = Order.builder()
                .user(user)
                .orderDate(LocalDateTime.now())
                .items(orderItems)
                .totalAmount(total)
                .build();

        orderRepository.save(order);
        cartRepository.deleteAll(cartItems);
    }

    @Override
    public List<Order> getOrders(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return orderRepository.findByUser(user);
    }
}
