package com.example.demo.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String cartId;
    private List<CartItem> items = new ArrayList<>();
    private double totalPrice;

    public String getCartId() {
        return cartId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
