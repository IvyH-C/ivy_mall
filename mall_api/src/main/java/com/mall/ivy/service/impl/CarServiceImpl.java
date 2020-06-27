package com.mall.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import com.mall.ivy.dto.car.CarListDTO;
import com.mall.ivy.dto.car.CarSaveDTO;
import com.mall.ivy.dto.car.CarUpdateDTO;
import com.mall.ivy.mapper.CarMapper;
import com.mall.ivy.model.Car;
import com.mall.ivy.service.CarService;
import com.mall.ivy.vo.car.CarVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CarService实现
* Created by Ivy.
*/
@Service
@Transactional
public class CarServiceImpl implements CarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    CarMapper carMapper;

    @Override
    public Result saveCar(CarSaveDTO dto) {
        //TODO 封装Car

        Car car = new Car();
        BeanUtils.copyProperties(dto, car);
        if(carMapper.insert(car) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteCar(Integer id) {
        if(carMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getCar(Integer id) {
        Car car = carMapper.selectByPrimaryKey(id);
        if(car != null) {
            //TODO 封装返回的内容
            CarVO result = new CarVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listCar(CarListDTO dto, int pageNo, int pageSize) {
        Page<Car> page = PageHelper.startPage(pageNo, pageSize);
        //List<Car> cars = carMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateCar(Integer id, CarUpdateDTO dto) {
        Car car = carMapper.selectByPrimaryKey(id);
        if(car != null) {
            //TODO 设值

            if(carMapper.updateByPrimaryKey(car) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}