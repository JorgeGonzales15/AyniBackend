package com.greatminds.ayni.shopping.domain.services;

import com.greatminds.ayni.shopping.domain.model.aggregates.Order;
import com.greatminds.ayni.shopping.domain.model.queries.GetOrderByIdQuery;
import com.greatminds.ayni.shopping.domain.model.queries.GetOrderBySaleIdQuery;

import java.util.List;
import java.util.Optional;

public interface OrderQueryService {

    Optional<Order> handle(GetOrderByIdQuery query);

    Optional<Order> handle(GetOrderBySaleIdQuery query);

    List<Order> getAllOrders();

    //List<Order> getOrdersForUser(Long userId);

    //List<Order> getOrdersForSale(Long saleId);

    // List<Order> getPendingOrders();

    //List<Order> getCompletedOrders();

    //List<Order> searchOrders(String searchTerm);

    //Order getOrderWithHighestTotal();

    //Order getOrderWithLowestTotal();

    //Double calculateAverageOrderTotal();

    //Long countTotalOrders();
}