package com.greatminds.ayni.shopping.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public record CreateOrderResource(String description, Integer quantity, double totalPrice, String paymentMethod, String status, Long saleId) {
}