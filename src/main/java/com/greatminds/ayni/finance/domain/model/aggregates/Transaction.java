package com.greatminds.ayni.finance.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name= "transactions")
public class Transaction extends AbstractAggregateRoot<Transaction> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String costName;
    private String date;
    private String description;
    private String type;
    private Double price;
    private String quantity;
    private Long userId;


    public Transaction(String costName, String description, String date, String type, Double price, String quantity, Long userId) {
        this.costName = costName;
        this.description = description;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.date=date;
        this.userId=userId;
    }


    public Transaction() {
    }

    public Transaction update(String costName, String description, String date, String type, Double price, String quantity) {
        if (costName != null) {
            this.costName = costName;
        }
        if (description != null) {
            this.description = description;
        }
        if (date != null) {
            this.date = date;
        }
        if (type != null) {
            this.type = type;
        }
        if (price != null) {
            this.price = price;
        }
        if (quantity != null) {
            this.quantity = quantity;
        }
        return this;
    }


}
