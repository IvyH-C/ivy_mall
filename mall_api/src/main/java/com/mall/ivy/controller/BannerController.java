package com.mall.ivy.controller;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

}
