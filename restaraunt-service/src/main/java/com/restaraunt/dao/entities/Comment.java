package com.restaraunt.dao.entities;

import java.sql.Timestamp;

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

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "comment_id")
    private Long id;

    @NotBlank
    @Column(name = "comment_date")
    private Timestamp dateOfOrder;

    @NotBlank
    @Column(name = "comment_text")
    private String text;

    @Column(name = "comment_rating")
    private double rating;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
