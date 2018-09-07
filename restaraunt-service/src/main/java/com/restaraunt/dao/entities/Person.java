package com.restaraunt.dao.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import java.sql.Timestamp;

@Embeddable
public class Person {
    @NotBlank
    @Column(name = "user_first_name")
    private String firstName;

    @NotBlank
    @Column(name = "user_last_name")
    private String lastName;

    @Column(name = "user_date_of_birthday")
    private Timestamp dateOfBirthday;
}
