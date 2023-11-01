package com.greatminds.ayni.shopping.interfaces.rest.resources;

public record OrderResource(Long Id, String description, Integer quantity, double totalPrice, String paymentMethod) {
}