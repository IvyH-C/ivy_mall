package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.banner.BannerSaveDTO;
import com.mall.ivy.dto.banner.BannerUpdateDTO;

/**
* BannerService接口
* Created by Ivy.
*/
public interface BannerService {

    Result saveBanner(BannerSaveDTO dto);

    Result deleteBanner(Integer id);

    Result getBanner(Integer id);

    Result listBanner();

    Result updateBanner(Integer id, BannerUpdateDTO dto);
}