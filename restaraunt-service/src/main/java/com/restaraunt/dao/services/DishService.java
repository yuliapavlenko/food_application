package com.restaraunt.dao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.restaraunt.dao.entities.Dish;
import com.restaraunt.dao.repositories.DishRepository;
import com.restaraunt.rest.dto.DishDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DishDto saveDish(DishDto dishDto){
        Dish dish = modelMapper.map(dishDto, Dish.class);
        return modelMapper.map(dishRepository.save(dish), DishDto.class);
    }

    public Dish updateDish(Dish dish){
        return dish;
    }

    public Optional<DishDto> getDishById(Long id){
        Optional<Dish> dish = dishRepository.findById(id);
        return Optional.of(modelMapper.map(dish, DishDto.class));
    }

    public List<DishDto> getAllDishes(){
        List<DishDto> listOfDishes = dishRepository.findAll().stream()
                .map(dish -> modelMapper.map(dish, DishDto.class))
                .collect(Collectors.toList());
        return listOfDishes;
    }

    public void deleteDish(Long id){
        dishRepository.deleteById(id);
    }
}
