package com.restaraunt.dao.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.restaraunt.dao.entities.enums.Category;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dishes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish implements Serializable {
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
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "dish_amount")
    private double amount;

    @Column(name = "dish_rating")
    private double rating;

    @OneToMany(mappedBy = "dish")
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new HashSet<>();
}
