package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryListDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategorySaveDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryUpdateDTO;

/**
* GoodsCategoryService接口
* Created by Ivy.
*/
public interface GoodsCategoryService {

    Result saveGoodsCategory(Integer id, GoodsCategorySaveDTO dto);

    Result deleteGoodsCategory(Integer id);

    Result getGoodsCategory(Integer id);

    Result listGoodsCategory(int pageNo, int pageSize);

    Result updateGoodsCategory(Integer id, GoodsCategoryUpdateDTO dto);
}