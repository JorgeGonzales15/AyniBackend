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
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private Long saleId;

    @Getter
    private Long orderedBy;

    @Getter
    private Long acceptedBy;

    @Getter
    private String description;

    @Getter
    private Integer quantity;

    @Getter
    private String status;

    @Getter
    private Date orderedDate;

    @Getter
    private Double totalPrice;

    @Getter
    private String paymentMethod;

    public Order(String description, Double totalPrice, Integer quantity, String paymentMethod, String status, Long saleId, Long orderedBy, Long acceptedBy, Date orderedDate) {
        this.description = description;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.orderedBy = orderedBy;
        this.acceptedBy = acceptedBy;
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
