package com.restaraunt.dao.entities;

import com.restaraunt.dao.entities.enums.Status;
import com.sun.istack.internal.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "order_id")
    private Long id;

    @NotBlank
    @Column(name = "order_date")
    private Timestamp dateOfOrder;

    @Column(name = "order_cooker")
    private String cooker;

    @NotBlank
    @Column(name = "order_status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
