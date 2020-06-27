package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.user.UserListDTO;
import com.mall.ivy.dto.user.UserSaveDTO;
import com.mall.ivy.dto.user.UserUpdateDTO;

/**
* UserService接口
* Created by Ivy.
*/
public interface UserService {

    Result saveUser(UserSaveDTO dto);

    Result deleteUser(Integer id);

    Result getUser(Integer id);

    Result listUser(UserListDTO dto, int pageNo, int pageSize);

    Result updateUser(Integer id, UserUpdateDTO dto);
}