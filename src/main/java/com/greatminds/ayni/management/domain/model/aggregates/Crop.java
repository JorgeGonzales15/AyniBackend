package com.greatminds.ayni.management.domain.model.aggregates;

import com.greatminds.ayni.management.domain.model.entities.Product;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @Getter
    private Boolean pickUpWeed;

    @Getter
    private Boolean fertilizeCrop;

    @Getter
    private Boolean oxygenateCrop;

    @Getter
    private Boolean makeCropLine;

    @Getter
    private Boolean makeCropHole;

    @Getter
    private Long wateringDays;

    @Getter
    private Long pestCleanupDays;

    @Getter
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Getter
    private Long userId;

    public Crop() {
    }

    public Crop(String name, Boolean pickUpWeed, Boolean fertilizeCrop, Boolean oxygenateCrop, Boolean makeCropLine,
                Boolean makeCropHole, Long wateringDays, Long pestCleanupDays, Product product, Long userId) {
        this.name = name;
        this.pickUpWeed = pickUpWeed;
        this.fertilizeCrop = fertilizeCrop;
        this.oxygenateCrop = oxygenateCrop;
        this.makeCropLine = makeCropLine;
        this.makeCropHole = makeCropHole;
        this.wateringDays = wateringDays;
        this.pestCleanupDays = pestCleanupDays;
        this.product = product;
        this.userId = userId;
    }

    public Crop updateInformation(String name, Boolean pickUpWeed, Boolean fertilizeCrop, Boolean oxygenateCrop, Boolean makeCropLine,
                                  Boolean makeCropHole, Long wateringDays, Long pestCleanupDays, Product product, Long userId) {
        this.name = name;
        this.pickUpWeed = pickUpWeed;
        this.fertilizeCrop = fertilizeCrop;
        this.oxygenateCrop = oxygenateCrop;
        this.makeCropLine = makeCropLine;
        this.makeCropHole = makeCropHole;
        this.wateringDays = wateringDays;
        this.pestCleanupDays = pestCleanupDays;
        this.product = product;
        this.userId = userId;
        return this;
    }
}
