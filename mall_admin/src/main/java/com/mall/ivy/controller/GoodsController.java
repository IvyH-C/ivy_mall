package com.mall.ivy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mall.ivy.dto.goods.GoodsListDTO;
import com.mall.ivy.dto.goods.GoodsSaveDTO;
import com.mall.ivy.dto.goods.GoodsUpdateDTO;
import com.mall.ivy.service.GoodsService;
import com.mall.ivy.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 新增商品
     * @param dto
     * @return
     */
    @PostMapping("")
    public Result save(@RequestBody GoodsSaveDTO dto) {
        return goodsService.saveGoods(dto);
    }

    /**
     * 删除商品（逻辑删除）
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return goodsService.deleteGoods(id);
    }

    /**
     * 商品详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return goodsService.getGoods(id);
    }

    /**
     * 返回全部商品
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public Result list(int pageNo, int pageSize){
        return goodsService.listGoods(pageNo, pageSize);
    }

    /**
     * 修改商品
     * @param id
     * @param dto
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody GoodsUpdateDTO dto){
        return goodsService.updateGoods(id, dto);
    }
}