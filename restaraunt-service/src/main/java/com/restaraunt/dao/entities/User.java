package com.restaraunt.dao.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.restaraunt.dao.entities.enums.UserRole;

import com.sun.istack.internal.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "user_id")
    private Long id;

    @NotBlank
    @Column(name = "user_email")
    private String email;

    @NotBlank
    @Column(name = "user_password")
    private String password;

    @NotBlank
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Embedded
    private Person person;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new HashSet<>();
    
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", person=" + person +
                ", orders=" + orders +
                ", comments=" + comments +
                '}';
    }
}
