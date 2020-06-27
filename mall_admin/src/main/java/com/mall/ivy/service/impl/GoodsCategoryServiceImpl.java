package com.mall.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.resp.PageVO;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryListDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategorySaveDTO;
import com.mall.ivy.dto.goodsCategory.GoodsCategoryUpdateDTO;
import com.mall.ivy.vo.goodsCategory.GoodsCategoryVO;
import com.mall.ivy.mapper.GoodsCategoryMapper;
import com.mall.ivy.model.GoodsCategory;
import com.mall.ivy.model.GoodsCategoryExample;
import com.mall.ivy.service.GoodsCategoryService;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public Result saveGoodsCategory(Integer id, GoodsCategorySaveDTO dto) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(id);
        if (goodsCategory != null){
            return ResultUtil.error(ResultEnum.DATA_EXISIS);
        }
        if(dto.getCategoryName() == null ){
            return ResultUtil.error(ResultEnum.CATEGORY_EMPTY);
        }
        if(dto.getFatherId() == null){
            return ResultUtil.error(ResultEnum.FATHERID_EMPTY);
        }
        goodsCategory = new GoodsCategory();
        BeanUtils.copyProperties(dto, goodsCategory);
        if(goodsCategoryMapper.insert(goodsCategory) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteGoodsCategory(Integer id) {
        if(goodsCategoryMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getGoodsCategory(Integer id) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(id);
        if(goodsCategory == null) {
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        GoodsCategoryVO vo = new GoodsCategoryVO();
        vo.setCategoryName(goodsCategory.getCategoryName());
        vo.setFatherId(goodsCategory.getFatherId());
        vo.setGmtModify(goodsCategory.getGmtModify());
        vo.setGmtCreate(goodsCategory.getGmtCreate());
        return ResultUtil.success(vo);
    }

    @Override
    public Result listGoodsCategory(int pageNo, int pageSize) {
        List<GoodsCategory> goodsCategorys = goodsCategoryMapper.selectAll();
        List<GoodsCategoryVO> vos = new ArrayList<>();

        for(GoodsCategory gc: goodsCategorys){
           GoodsCategoryVO vo = new GoodsCategoryVO(gc.getId(),gc.getFatherId(),gc.getCategoryName(),
                   gc.getGmtCreate(),gc.getGmtModify());
           vos.add(vo);
        }
        return ResultUtil.success(vos);
    }

    @Override
    public Result updateGoodsCategory(Integer id, GoodsCategoryUpdateDTO dto) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(id);
        if(goodsCategory == null ) {
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        goodsCategory.setCategoryName(dto.getCategoryName());
        goodsCategory.setFatherId(dto.getFatherId());
        goodsCategory.setGmtModify(new Date());
        if(goodsCategoryMapper.updateByPrimaryKey(goodsCategory) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}