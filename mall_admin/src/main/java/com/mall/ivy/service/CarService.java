package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.car.CarListDTO;
import com.mall.ivy.dto.car.CarSaveDTO;
import com.mall.ivy.dto.car.CarUpdateDTO;

/**
* CarService接口
* Created by Ivy.
*/
public interface CarService {

    Result saveCar(CarSaveDTO dto);

    Result deleteCar(Integer id);

    Result getCar(Integer id);

    Result listCar(CarListDTO dto, int pageNo, int pageSize);

    Result updateCar(Integer id, CarUpdateDTO dto);
}