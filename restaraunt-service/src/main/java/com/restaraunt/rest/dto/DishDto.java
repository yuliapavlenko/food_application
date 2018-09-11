package com.restaraunt.rest.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaraunt.dao.entities.Order;
import com.restaraunt.dao.entities.enums.Category;
import com.sun.istack.internal.NotNull;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto implements Serializable{
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String composition;

    @NotBlank
    private String category;

    private double amount;

    private double rating;

    private Set<OrderDto> orders;

    private Set<CommentDto> comments;
}
