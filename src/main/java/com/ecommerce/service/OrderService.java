package com.ecommerce.service;

import com.ecommerce.model.Order;

import java.util.List;

public interface OrderService {
    void checkout(String email);
    List<Order> getOrders(String email);
}
