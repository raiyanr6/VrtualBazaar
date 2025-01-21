package com.example.demo.cart;

import com.example.demo.base.Product;
import com.example.demo.cart.Cart;
import com.example.demo.cart.CartItem;
import com.example.demo.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {
    private final Map<String, Cart> carts = new HashMap<>();

    @Autowired
    private InventoryService inventoryService;

    public Cart addToCart(String cartId, CartItem item) {
        Product product = inventoryService.getProductById(item.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (product.getStock() < item.getQuantity()) {
            throw new IllegalArgumentException("Insufficient stock");
        }

        // Deduct stock from inventory
        inventoryService.updateStock(product.getProductId(), product.getStock() - item.getQuantity());

        Cart cart = carts.getOrDefault(cartId, new Cart());
        cart.getItems().add(item);
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice() * item.getQuantity());
        carts.put(cartId, cart);

        return cart;
    }

    public Cart removeFromCart(String cartId, String productId) {
        Cart cart = carts.get(cartId);
        if (cart != null) {
            cart.getItems().removeIf(item -> item.getProductId().equals(productId));
            cart.setTotalPrice(cart.getItems().stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum());
        }
        return cart;
    }

    public Cart viewCart(String cartId) {
        return carts.get(cartId);
    }
}
