package com.restaraunt.dao.entities;

import com.restaraunt.dao.entities.enums.UserRole;

import com.sun.istack.internal.NotNull;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_role")
    private UserRole userRole;

    @Embedded
    private Person person;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

}
