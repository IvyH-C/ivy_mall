package com.mall.ivy.service.impl;

import com.alibaba.fastjson.JSON;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.redis.RedisService;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import com.mall.ivy.mapper.BannerMapper;
import com.mall.ivy.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    RedisService redisService;



}
