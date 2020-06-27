package com.mall.ivy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.redis.RedisService;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import com.mall.ivy.dto.goods.GoodsListDTO;
import com.mall.ivy.dto.goods.GoodsSaveDTO;
import com.mall.ivy.dto.goods.GoodsUpdateDTO;
import com.mall.ivy.mapper.GoodsMapper;
import com.mall.ivy.model.Goods;
import com.mall.ivy.service.GoodsService;
import com.mall.ivy.vo.goods.GoodsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* GoodsService实现
* Created by Ivy.
*/
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    RedisService redisService;



    @Override
    public Result getGoods(Integer id) {
        String redisGoods = redisService.getValue(id.toString());
        if(redisGoods != null ) {
            return ResultUtil.success(redisGoods);
        }
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        if(goods == null){
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        redisService.setKey(id.toString(), JSON.toJSONString(goods));
        return ResultUtil.success(goods);
    }

    @Override
    public Result listGoods(GoodsListDTO dto, int pageNo, int pageSize) {
        Page<Goods> page = PageHelper.startPage(pageNo, pageSize);
        //List<Goods> goodss = goodsMapper.list(dto);
        return ResultUtil.success();
    }



}