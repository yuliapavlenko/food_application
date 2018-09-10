package com.restaraunt.rest.controllers;

import java.util.List;

import com.restaraunt.dao.services.DishService;
import com.restaraunt.rest.dto.DishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/dishes")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping
    private ResponseEntity<List<DishDto>> getAllDishes(){
        return ResponseEntity.ok().body(dishService.getAllDishes());
    }
}
