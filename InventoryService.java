package com.example.demo.inventory;

import com.example.demo.base.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryService {
    private final Map<String, Product> inventory = new HashMap<>();

    public List<Product> getProducts() {
        return new ArrayList<>(inventory.values());
    }

    public Product addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        return product;
    }

    public Product updateStock(String productId, int stock) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setStock(stock);
        }
        return product;
    }

    public Optional<Product> getProductById(String productId) {
        return Optional.ofNullable(inventory.get(productId));
    }
}
