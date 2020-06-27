package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.admin.AdminSaveDTO;
import com.mall.ivy.dto.admin.AdminUpdateDTO;

/**
* AdminService接口
* Created by Ivy.
*/
public interface AdminService {

    Result saveAdmin(AdminSaveDTO dto);

    Result deleteAdmin(Integer id);

    Result getAdmin(Integer id);

    Result listAdmin(int pageNo, int pageSize);

    Result updateAdmin(Integer id, AdminUpdateDTO dto);

    Result sendVerifyEmail(String mailTo);
}