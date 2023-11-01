package com.greatminds.ayni.shopping.interfaces.rest.transform;


import com.greatminds.ayni.shopping.domain.model.aggregates.Order;
import com.greatminds.ayni.shopping.interfaces.rest.resources.OrderResource;

import java.util.List;
import java.util.stream.Collectors;

public class OrderResourceFromEntityAssembler {

    public static OrderResource toResourceFromEntity(Order entity) {
        return new OrderResource(entity.getId(), entity.getDescription(), entity.getQuantity(), entity.getTotalPrice(), entity.getPaymentMethod());
    }

    public static List<OrderResource> toResourceListFromEntities(List<Order> orders) {
        return orders.stream()
                .map(OrderResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
    }

}