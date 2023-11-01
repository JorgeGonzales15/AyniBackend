package com.greatminds.ayni.shopping.application.internal.commandservices;

import com.greatminds.ayni.shopping.domain.model.commands.CreateOrderCommand;
import com.greatminds.ayni.shopping.interfaces.rest.resources.UpdateOrderResource;
import com.greatminds.ayni.shopping.domain.model.aggregates.Order;
import com.greatminds.ayni.shopping.domain.services.OrderCommandService;
import com.greatminds.ayni.shopping.infrastructure.persistence.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final OrderRepository orderRepository;
    public OrderCommandServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Long handle(CreateOrderCommand command) {
        Date currentDate = new Date();
        var order = new Order(command.description(), command.totalPrice(), command.quantity(), command.paymentMethod(), command.status(), command.saleId());
        order.updateDate(currentDate);
        orderRepository.save(order);
        return order.getId();
    }

    @Override
    public Long deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new IllegalArgumentException("Order with ID " + orderId + " not found");
        }
        orderRepository.deleteById(orderId);
        return orderId;
    }

    @Override
    public Long updateOrder(Long orderId, UpdateOrderResource request) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order with ID " + orderId + " not found"));

        order.update(new Order(request.description(), request.totalPrice(), request.quantity(), request.paymentMethod() , request.status(), request.saleId()));
        orderRepository.save(order);
        return order.getId();
    }
}