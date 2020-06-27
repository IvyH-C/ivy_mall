package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.goods.GoodsListDTO;
import com.mall.ivy.dto.goods.GoodsSaveDTO;
import com.mall.ivy.dto.goods.GoodsUpdateDTO;

/**
* GoodsService接口
* Created by Ivy.
*/
public interface GoodsService {

    Result saveGoods(GoodsSaveDTO dto);

    Result deleteGoods(Integer id);

    Result getGoods(Integer id);

    Result listGoods(int pageNo, int pageSize);

    Result updateGoods(Integer id, GoodsUpdateDTO dto);
}