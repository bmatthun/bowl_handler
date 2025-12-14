package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Összetevő neve")
    private String name;
    @Column(name = "Mennyiség")
    private Integer quantity;
    @Column(name = "Mértékegység")
    private String unit;
}
