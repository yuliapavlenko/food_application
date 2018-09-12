package com.restaraunt.dao.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class Person implements Serializable {
    @NotBlank
    @Column(name = "user_first_name")
    private String firstName;

    @NotBlank
    @Column(name = "user_last_name")
    private String lastName;

    @Column(name = "user_date_of_birthday")
    private Timestamp dateOfBirthday;
    
    @Column(name = "user_photo")
    private String photo;
    
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirthday=" + dateOfBirthday + '\'' +
                ", photo=" +
                '}';
    }
}
