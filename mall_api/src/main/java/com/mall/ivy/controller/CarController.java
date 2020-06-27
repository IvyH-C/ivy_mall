package com.mall.ivy.controller;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.car.CarListDTO;
import com.mall.ivy.dto.car.CarSaveDTO;
import com.mall.ivy.dto.car.CarUpdateDTO;
import com.mall.ivy.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * CarController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/car")
public class CarController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @PostMapping("")
    public Result save(@RequestBody CarSaveDTO dto) {
        return carService.saveCar(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return carService.deleteCar(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return carService.getCar(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody CarListDTO dto, int pageNo, int pageSize){
        return carService.listCar(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CarUpdateDTO dto){
        return carService.updateCar(id, dto);
    }
}