package com.mall.ivy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mall.ivy.dto.delivery.DeliveryListDTO;
import com.mall.ivy.dto.delivery.DeliverySaveDTO;
import com.mall.ivy.dto.delivery.DeliveryUpdateDTO;
import com.mall.ivy.service.DeliveryService;
import com.mall.ivy.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * DeliveryController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryController.class);

    @Autowired
    private DeliveryService deliveryService;


    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return deliveryService.getDelivery(id);
    }


    @GetMapping("/list")
    public Result list(@RequestBody DeliveryListDTO dto, int pageNo, int pageSize){
        return deliveryService.listDelivery(dto, pageNo, pageSize);
    }

}