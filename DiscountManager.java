package com.example.demo.discount;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DiscountManager {
    private final Map<String, Double> discountRates = new HashMap<>();

    public void addDiscount(String discountCode, double rate) {
        discountRates.put(discountCode, rate);
    }

    public double applyDiscount(String discountCode, double amount) {
        double rate = discountRates.getOrDefault(discountCode, 0.0);
        return amount - (amount * rate);
    }
}
