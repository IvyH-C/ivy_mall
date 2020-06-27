package com.mall.ivy.service.impl;

import com.mall.ivy.core.redis.RedisConfig;
import com.mall.ivy.core.redis.RedisService;
import com.mall.ivy.dto.banner.BannerSaveDTO;
import com.mall.ivy.dto.banner.BannerUpdateDTO;
import com.mall.ivy.service.BannerService;
import com.mall.ivy.vo.banner.BannerVO;
import com.mall.ivy.mapper.BannerMapper;
import com.mall.ivy.model.Banner;
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
* BannerService实现
* Created by Ivy.
*/
@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerServiceImpl.class);

    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    RedisService redisService;

    @Override
    public Result saveBanner(BannerSaveDTO dto) {
        if(dto == null ){
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        Banner banner = bannerMapper.selectByImg(dto.getImg());
        if(banner != null){
            return ResultUtil.error(ResultEnum.DATA_EXISIS);
        }
        //BeanUtils很方便，会自动将dto中的属性值粘贴到banner对象中对应的属性中，属性名称要保持一致；省略了挨个去set的步骤。
        BeanUtils.copyProperties(dto, banner);
        banner.setGmtCreate(new Date());
        banner.setGmtModify(new Date());
        if(bannerMapper.insert(banner) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteBanner(Integer id) {
        Banner banner = new Banner();
        banner.setId(id);
        banner.setDel(true);
        banner.setGmtModify(new Date());
        if(bannerMapper.updateByPrimaryKey(banner) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getBanner(Integer id) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        if(banner == null){
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        return ResultUtil.success(banner);
        }


    @Override
    public Result listBanner() {
        List<Banner> banners = bannerMapper.selectAll();
        List<BannerVO> vos = new ArrayList<>();
        for (Banner banner : banners) {
            BannerVO vo = new BannerVO(banner.getId(), banner.getImg(), banner.getUrl(), banner.getGmtCreate(),banner.getGmtModify());
            vos.add(vo);
        }
        return ResultUtil.success(vos);
    }

    @Override
    public Result updateBanner(Integer id, BannerUpdateDTO dto) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        if(banner == null){
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        banner.setImg(dto.getImg());
        banner.setUrl(dto.getUrl());
        banner.setDel(false);
        banner.setGmtModify(new Date());
        if(bannerMapper.updateByPrimaryKey(banner) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}