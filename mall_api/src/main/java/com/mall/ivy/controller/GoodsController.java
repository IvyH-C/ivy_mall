package com.mall.ivy.controller;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.goods.GoodsListDTO;
import com.mall.ivy.dto.goods.GoodsSaveDTO;
import com.mall.ivy.dto.goods.GoodsUpdateDTO;
import com.mall.ivy.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * GoodsController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    /**
     * 返回商品详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return goodsService.getGoods(id);
    }


    @GetMapping("/list")
    public Result list(@RequestBody GoodsListDTO dto, int pageNo, int pageSize){
        return goodsService.listGoods(dto, pageNo, pageSize);
    }

}