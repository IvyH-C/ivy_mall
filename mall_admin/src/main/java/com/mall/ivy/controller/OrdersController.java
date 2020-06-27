package com.mall.ivy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mall.ivy.dto.orders.OrdersListDTO;
import com.mall.ivy.dto.orders.OrdersSaveDTO;
import com.mall.ivy.dto.orders.OrdersUpdateDTO;
import com.mall.ivy.service.OrdersService;
import com.mall.ivy.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("")
    public Result save(@RequestBody OrdersSaveDTO dto) {
        return ordersService.saveOrders(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ordersService.deleteOrders(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return ordersService.getOrders(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody OrdersListDTO dto, int pageNo, int pageSize){
        return ordersService.listOrders(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody OrdersUpdateDTO dto){
        return ordersService.updateOrders(id, dto);
    }
}