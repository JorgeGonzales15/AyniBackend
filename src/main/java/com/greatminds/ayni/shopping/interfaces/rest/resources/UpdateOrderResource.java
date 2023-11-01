package com.greatminds.ayni.shopping.interfaces.rest.resources;

public record UpdateOrderResource(String description, Integer quantity, double totalPrice, String paymentMethod, String status, Long saleId) {
}
