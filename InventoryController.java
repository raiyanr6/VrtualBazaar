package com.example.demo.inventory;

import com.example.demo.base.Product;
import com.example.demo.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(inventoryService.addProduct(product));
    }

    @PutMapping("/{productId}/update-stock")
    public ResponseEntity<Product> updateStock(@PathVariable String productId, @RequestParam int stock) {
        return ResponseEntity.ok(inventoryService.updateStock(productId, stock));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(inventoryService.getProducts());
    }
}
