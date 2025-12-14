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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "order_bowl",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "bowl_id"))
    private List<Bowl> bowls;

    @Column(name = "Mennyiség")
    private String quantity;

    @Column(name = "Mértékegység")
    private String unit = "db";

    @Column(name = "Teljes ár")
    private Integer price; //ennek a Bowl x unit -ból kellene jönnie, de lehetséges módosítani
}
