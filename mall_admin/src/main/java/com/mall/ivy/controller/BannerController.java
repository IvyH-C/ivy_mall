package com.mall.ivy.controller;

import com.mall.ivy.service.BannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mall.ivy.dto.banner.BannerSaveDTO;
import com.mall.ivy.dto.banner.BannerUpdateDTO;
import com.mall.ivy.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * BannerController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/banner")
public class BannerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerController.class);

    @Autowired
    private BannerService bannerService;

    /**
     * 添加轮播图
     * @param dto
     * @return
     */
    @PostMapping("")
    public Result save(@RequestBody BannerSaveDTO dto) {
        return bannerService.saveBanner(dto);
    }

    /**
     * 删除轮播图（逻辑删除）
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return bannerService.deleteBanner(id);
    }

    /**
     * 获取轮播图
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return bannerService.getBanner(id);
    }

    /**
     * 返回所有轮播图
     * @return
     */
    @GetMapping("/list")
    public Result list(){

        return bannerService.listBanner();
    }

    /**
     * 更新轮播图
     * @param id
     * @param dto
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody BannerUpdateDTO dto){
        return bannerService.updateBanner(id, dto);
    }
}