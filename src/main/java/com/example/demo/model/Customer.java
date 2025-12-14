package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Vendégek")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Név")
    private String name;

    @Column(name = "Telefon")
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Cím")
    private String address;

    @OneToMany(
            mappedBy = "customer",
            fetch = FetchType.LAZY,
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Order> orders;

    @Column(name = "Megjegyzés")
    private String note;
}
