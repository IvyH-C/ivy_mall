package com.mall.ivy.controller;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryListDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategorySaveDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryUpdateDTO;
import com.mall.ivy.service.GoodsCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * GoodsCategoryController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/goods_category")
public class GoodsCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsCategoryController.class);

    @Autowired
    private GoodsCategoryService goodsCategoryService;


    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return goodsCategoryService.getGoodsCategory(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody GoodsCategoryListDTO dto, int pageNo, int pageSize){
        return goodsCategoryService.listGoodsCategory(dto, pageNo, pageSize);
    }

}