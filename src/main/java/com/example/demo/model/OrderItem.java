package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Rendelt_étek")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bowl_id", nullable = false)
    private Bowl bowl;

    @Column(name = "darab", nullable = false)
    private Integer quantity;

    @Column(name = "Egységár", nullable = false)
    private Integer unitPrice;

    @Column(name = "Teljes_ár", nullable = false)
    private Integer lineTotal;

    @PrePersist
    @PreUpdate
    public void calculateTotals() {
        if (this.unitPrice == null) {
            this.unitPrice = this.bowl.getPrice(); // snapshot a mentés pillanatában
        }
        this.lineTotal = this.quantity * this.unitPrice;
    }
}