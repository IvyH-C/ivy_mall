package com.mall.ivy.controller;

import com.sun.istack.internal.Interned;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryListDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategorySaveDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryUpdateDTO;
import com.mall.ivy.service.GoodsCategoryService;
import com.mall.ivy.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     *新增商品分类
     * @param dto
     * @return
     */
    @PostMapping("")
    public Result save(@RequestParam Integer id, @RequestBody GoodsCategorySaveDTO dto) {
        return goodsCategoryService.saveGoodsCategory(id, dto);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return goodsCategoryService.deleteGoodsCategory(id);
    }

    /**
     * 获取分类
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return goodsCategoryService.getGoodsCategory(id);
    }

    /**
     * 返回全部分类
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public Result list(int pageNo, int pageSize){
        return goodsCategoryService.listGoodsCategory(pageNo, pageSize);
    }

    /**
     * 修改商品分类的信息
     * @param id
     * @param dto
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody GoodsCategoryUpdateDTO dto){
        return goodsCategoryService.updateGoodsCategory(id, dto);
    }
}