package com.mall.ivy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.redis.RedisService;
import com.mall.ivy.core.resp.PageVO;
import com.mall.ivy.dto.goods.GoodsListDTO;
import com.mall.ivy.dto.goods.GoodsSaveDTO;
import com.mall.ivy.dto.goods.GoodsUpdateDTO;
import com.mall.ivy.vo.goods.GoodsVO;
import com.mall.ivy.mapper.GoodsMapper;
import com.mall.ivy.model.Goods;
import com.mall.ivy.model.GoodsExample;
import com.mall.ivy.service.GoodsService;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public Result saveGoods(GoodsSaveDTO dto) {
       if(dto == null){
           return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
       }
        Goods goods = new Goods();
        goods.setDel(false);
        goods.setGmtCreate(new Date());
        goods.setGmtModify(new Date());
        BeanUtils.copyProperties(dto, goods);
        if(goodsMapper.insert(goods) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteGoods(Integer id) {

        redisService.delete(id.toString());

        if(goodsMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getGoods(Integer id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        if(goods == null){
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        return ResultUtil.success(goods);
    }

    @Override
    public Result listGoods(int pageNo, int pageSize) {
        Page<Goods> page = PageHelper.startPage(pageNo, pageSize);
        List<Goods> goodss = goodsMapper.selectAllGoods();

        PageVO vo = new PageVO();
        vo.setList(goodss);
        vo.setRowCount(page.getTotal());
        return ResultUtil.success(vo);
    }

    @Override
    public Result updateGoods(Integer id, GoodsUpdateDTO dto) {
        if(dto == null){
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        Goods goods = goodsMapper.selectByPrimaryKey(id);

        if(goods == null) {
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }

        BeanUtils.copyProperties(dto,goods);
        if(goodsMapper.updateByPrimaryKey(goods) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

}