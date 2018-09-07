package com.restaraunt.dao.entities;

import com.restaraunt.dao.entities.enums.Category;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "dish_id")
    private Long id;

    @NotBlank
    @Column(name = "dish_name")
    private String name;

    @Column(name = "dish_description")
    private String description;

    @NotBlank
    @Column(name = "dish_composition")
    private String composition;

    @NotBlank
    @Column(name = "dish_category")
    private Category category;

    @Column(name = "dish_amount")
    private double amount;

    @Column(name = "dish_rating")
    private double rating;

    @OneToMany(mappedBy = "dish")
    private Set<Order> orders;
}
