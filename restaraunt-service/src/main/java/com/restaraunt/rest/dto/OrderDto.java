package com.restaraunt.rest.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaraunt.dao.entities.Dish;
import com.restaraunt.dao.entities.User;
import com.restaraunt.dao.entities.enums.Status;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {
    @NotNull
    private Long id;

    @NotBlank
    private Timestamp dateOfOrder;

    private String cooker;

    @NotBlank
    private Status status;

    @JsonIgnore
    private DishDto dish;
    @JsonIgnore
    private UserDto user;
}
