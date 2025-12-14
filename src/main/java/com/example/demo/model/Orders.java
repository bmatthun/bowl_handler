package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Megrendelő")
    private String name;
    @Column(name = "Megrendelés dátuma")
    private String date;
    @Column(name = "Megrendelési szám")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderNumber;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "orders_bowl",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "bowl_id"))

    @Column(name = "Tálak")
    private List<Bowl> bowls;
    @Column(name = "Mennyiség")
    private String quantity;
    @Column(name = "Mértékegység")
    private String unit = "db";
}
