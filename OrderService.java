package com.example.demo.order;

import com.example.demo.order.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {
    private final Map<String, Order> orders = new HashMap<>();

    public Order createOrder(Order order) {
        orders.put(order.getOrderId(), order);
        order.setStatus("PENDING");
        return order;
    }

    public Order confirmOrder(String orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus("COMPLETED");
        }
        return order;
    }

    public Order viewOrder(String orderId) {
        return orders.get(orderId);
    }
}
