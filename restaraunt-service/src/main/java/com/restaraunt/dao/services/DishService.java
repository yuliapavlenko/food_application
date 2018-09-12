package com.restaraunt.dao.services;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaraunt.dao.entities.Dish;
import com.restaraunt.dao.repositories.DishRepository;
import com.restaraunt.exceptionhandler.ServiceException;
import com.restaraunt.rest.dto.DishDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DishService {
    @Autowired
    private DishRepository dishRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Transactional
    public DishDto saveDish(DishDto dishDto) {
        Dish dish = modelMapper.map(dishDto, Dish.class);
        
        try {
            return modelMapper.map(dishRepository.save(dish), DishDto.class);
        } catch (RuntimeException e) {
            log.error("Exception occurred during saving of dish with id = " + dish.getId(), e.getMessage());
            throw new ServiceException("Exception occurred during saving of dish " + dish.toString(), e.getCause());
        }
        
    }
    
    public Optional<DishDto> findDishById(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        
        if (dish.isPresent()) {
            return Optional.of(modelMapper.map(dish, DishDto.class));
        } else {
            log.error("Exception occurred during search of dish " + dish.toString());
            throw new ServiceException("Exception occurred during search of dish " + dish.toString());
        }
    }
    
    public List<DishDto> getAllDishes() {
        List<DishDto> listOfDishes;
        
        try {
            listOfDishes = dishRepository.findAll().stream()
                    .map(dish -> modelMapper.map(dish, DishDto.class))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            log.error("Exception occurred during search of all dishes", e.getMessage());
            throw new ServiceException("Exception occurred during search of all dishes", e.getCause());
        }
        return listOfDishes;
    }
    
    @Transactional
    public void deleteDish(Long id) {
        try {
            dishRepository.deleteById(id);
        } catch (RuntimeException e) {
            log.error("Exception occurred during deleting of dish with id =" + id, e.getMessage());
            throw new ServiceException("Exception occurred during deleting of dish with id = " + id, e.getCause());
        }
    }
}
