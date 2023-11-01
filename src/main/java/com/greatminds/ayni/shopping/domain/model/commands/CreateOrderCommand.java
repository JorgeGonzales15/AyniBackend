package com.greatminds.ayni.shopping.domain.model.commands;

import lombok.Getter;

import java.util.Date;

@Getter
public record CreateOrderCommand(String description, Integer quantity, double totalPrice, String paymentMethod, String status, Long saleId) {

}