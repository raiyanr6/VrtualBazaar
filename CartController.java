package com.example.demo.cart;

import com.example.demo.cart.Cart;
import com.example.demo.cart.CartItem;
import com.example.demo.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/{cartId}/add")
    public ResponseEntity<Cart> addItem(@PathVariable String cartId, @RequestBody CartItem item) {
        return ResponseEntity.ok(cartService.addToCart(cartId, item));
    }

    @DeleteMapping("/{cartId}/remove/{productId}")
    public ResponseEntity<Cart> removeItem(@PathVariable String cartId, @PathVariable String productId) {
        return ResponseEntity.ok(cartService.removeFromCart(cartId, productId));
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> viewCart(@PathVariable String cartId) {
        return ResponseEntity.ok(cartService.viewCart(cartId));
    }
}
