package com.mall.ivy.controller;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.orders.OrdersListDTO;
import com.mall.ivy.dto.orders.OrdersSaveDTO;
import com.mall.ivy.dto.orders.OrdersUpdateDTO;
import com.mall.ivy.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * OrdersController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrdersService ordersService;


    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return ordersService.getOrders(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody OrdersListDTO dto, int pageNo, int pageSize){
        return ordersService.listOrders(dto, pageNo, pageSize);
    }


}