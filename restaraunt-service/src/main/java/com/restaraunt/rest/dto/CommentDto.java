package com.restaraunt.rest.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CommentDto implements Serializable {
    @NotNull
    private Long id;

    @NotBlank
    private Timestamp dateOfOrder;

    @NotBlank
    private String text;

    private double rating;

    @JsonIgnore
    private DishDto dish;
    @JsonIgnore
    private UserDto user;
}
