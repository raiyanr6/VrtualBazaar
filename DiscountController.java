package com.example.demo.discount;

import com.example.demo.discount.DiscountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
    @Autowired
    private DiscountManager discountManager;

    @PostMapping("/add")
    public ResponseEntity<String> addDiscount(@RequestParam String code, @RequestParam double rate) {
        discountManager.addDiscount(code, rate);
        return ResponseEntity.ok("Discount added successfully.");
    }

    @GetMapping("/apply")
    public ResponseEntity<Double> applyDiscount(@RequestParam String code, @RequestParam double amount) {
        return ResponseEntity.ok(discountManager.applyDiscount(code, amount));
    }
}
