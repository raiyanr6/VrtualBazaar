package com.example.demo.order;

import com.example.demo.order.Order;
import com.example.demo.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @PutMapping("/{orderId}/confirm")
    public ResponseEntity<Order> confirmOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.confirmOrder(orderId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> viewOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.viewOrder(orderId));
    }
}
