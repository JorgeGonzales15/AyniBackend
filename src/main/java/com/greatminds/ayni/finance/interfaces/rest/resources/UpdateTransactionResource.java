package com.greatminds.ayni.finance.interfaces.rest.resources;
public record UpdateTransactionResource(
        String costName, String description, String date, String type, double price, String quantity, Long userId
) {

}
