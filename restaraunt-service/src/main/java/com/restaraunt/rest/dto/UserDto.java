package com.restaraunt.rest.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaraunt.dao.entities.Order;
import com.restaraunt.dao.entities.enums.UserRole;
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
public class UserDto implements Serializable {
    @NotNull
    private Long id;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private UserRole userRole;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private Timestamp dateOfBirthday;
    
    private String photo;

    private Set<OrderDto> orders;

    private Set<CommentDto> comments;
}
