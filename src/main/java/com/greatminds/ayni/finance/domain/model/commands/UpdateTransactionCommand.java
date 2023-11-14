package com.greatminds.ayni.finance.domain.model.commands;

public record UpdateTransactionCommand(Long id, String costName, String description, String date, String type, double price, String quantity) {
}
