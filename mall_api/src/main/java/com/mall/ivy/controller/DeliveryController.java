package com.mall.ivy.controller;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.delivery.DeliveryListDTO;
import com.mall.ivy.dto.delivery.DeliverySaveDTO;
import com.mall.ivy.dto.delivery.DeliveryUpdateDTO;
import com.mall.ivy.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public Result save(@RequestBody DeliverySaveDTO dto) {
        return deliveryService.saveDelivery(dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return deliveryService.deleteDelivery(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return deliveryService.getDelivery(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody DeliveryListDTO dto, int pageNo, int pageSize){
        return deliveryService.listDelivery(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody DeliveryUpdateDTO dto){
        return deliveryService.updateDelivery(id, dto);
    }
}