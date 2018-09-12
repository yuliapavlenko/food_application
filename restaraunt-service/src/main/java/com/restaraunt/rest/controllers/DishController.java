package com.restaraunt.rest.controllers;

import static com.restaraunt.constants.Constants.DISH_SERVICE_PATH;

import java.util.List;
import java.util.Optional;

import com.restaraunt.dao.services.DishService;
import com.restaraunt.rest.dto.DishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = DISH_SERVICE_PATH)
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("/all")
    private ResponseEntity<List<DishDto>> getAllDishes(){
        return ResponseEntity.ok().body(dishService.getAllDishes());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<DishDto>> getDishById(@PathVariable Long id){
        Optional<DishDto> dishDto = dishService.findDishById(id);

        if (dishDto.isPresent()) {
            return ResponseEntity.ok().body(dishDto);
        }else{
            return ResponseEntity.notFound().build();}

    }

    @PostMapping
    private ResponseEntity<DishDto> createDish(@RequestBody DishDto dish){
        return ResponseEntity.ok().body(dishService.saveDish(dish));
    }
}
