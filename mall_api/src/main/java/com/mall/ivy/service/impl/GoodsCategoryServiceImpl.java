package com.mall.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryListDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategorySaveDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryUpdateDTO;
import com.mall.ivy.mapper.GoodsCategoryMapper;
import com.mall.ivy.model.GoodsCategory;
import com.mall.ivy.service.GoodsCategoryService;
import com.mall.ivy.vo.goodsCategory.GoodsCategoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* GoodsCategoryService实现
* Created by Ivy.
*/
@Service
@Transactional
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsCategoryServiceImpl.class);

    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public Result saveGoodsCategory(GoodsCategorySaveDTO dto) {
        //TODO 封装GoodsCategory

        GoodsCategory goodsCategory = new GoodsCategory();
        BeanUtils.copyProperties(dto, goodsCategory);
        if(goodsCategoryMapper.insert(goodsCategory) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteGoodsCategory(Integer id) {
        if(goodsCategoryMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getGoodsCategory(Integer id) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(id);
        if(goodsCategory != null) {
            //TODO 封装返回的内容
            GoodsCategoryVO result = new GoodsCategoryVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listGoodsCategory(GoodsCategoryListDTO dto, int pageNo, int pageSize) {
        Page<GoodsCategory> page = PageHelper.startPage(pageNo, pageSize);
        //List<GoodsCategory> goodsCategorys = goodsCategoryMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateGoodsCategory(Integer id, GoodsCategoryUpdateDTO dto) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(id);
        if(goodsCategory != null) {
            //TODO 设值

            if(goodsCategoryMapper.updateByPrimaryKey(goodsCategory) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}