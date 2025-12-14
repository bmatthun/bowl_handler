package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "Megrendelések")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "Megrendelés_dátuma")
    private LocalDate date;

    @Column(name = "Megrendelés_időpontja")
    private LocalTime time;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> orderItems;

    @Column(name = "darab")
    private String quantity;

    @Column(name = "Teljes ár")
    private Integer price; //ennek a Bowl x unit -ból kellene jönnie, de lehetséges módosítani

    @PrePersist
    @PreUpdate
    public void calculateTotalPrice() {
        this.price = this.orderItems.stream().mapToInt(OrderItem::getLineTotal).sum();
    }
}
