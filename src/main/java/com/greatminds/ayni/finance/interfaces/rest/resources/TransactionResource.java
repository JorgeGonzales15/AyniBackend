package com.greatminds.ayni.finance.interfaces.rest.resources;

public record TransactionResource(
        Long id, String costName, String date, String description, String type, double price, String quantity
) {
}
