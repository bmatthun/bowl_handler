package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Bowl")
public class Bowl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Tál típusa")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "bowl_ingredient",
    joinColumns = @JoinColumn(name = "bowl_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    @Column(name = "Összetevők")
    private List<Ingredient> ingredients;

    private Integer quantity;
    @Column(name = "Mértékegység")
    private String unit = "db";
}
