package com.greatminds.ayni.shopping.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Order extends AbstractAggregateRoot<Order> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long saleId;

    private Long orderedBy;

    private Long acceptedBy;

    private String description;

    private Integer quantity;

    private String status;

    private Date orderedDate;

    private Double totalPrice;

    private String paymentMethod;

    public Order(String description, Double totalPrice, Integer quantity, String paymentMethod, String status, Long saleId) {
        this.description = description;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.saleId = saleId;
    }

    public Order() {

    }

    public void update(Order request) {

        if (request.description != null) {
            this.description = request.description;
        }
        if (request.quantity != null) {
            this.quantity = request.quantity;
        }
        if (request.totalPrice != null) {
            this.totalPrice = request.totalPrice;
        }
        if (request.paymentMethod != null) {
            this.paymentMethod = request.paymentMethod;
        }
        if (request.status != null) {
            this.status = request.status;
        }
        if (request.paymentMethod != null) {
            this.saleId = request.saleId;
        }
    }

    public void updateDate(Date currentDate) {
        this.orderedDate = currentDate;
    }

}
