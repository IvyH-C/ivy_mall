package com.mall.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import com.mall.ivy.dto.user.UserListDTO;
import com.mall.ivy.dto.user.UserSaveDTO;
import com.mall.ivy.dto.user.UserUpdateDTO;
import com.mall.ivy.mapper.UserMapper;
import com.mall.ivy.model.User;
import com.mall.ivy.service.UserService;
import com.mall.ivy.vo.user.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UserService实现
* Created by Ivy.
*/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public Result saveUser(UserSaveDTO dto) {
        //TODO 封装User

        User user = new User();
        BeanUtils.copyProperties(dto, user);
        if(userMapper.insert(user) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteUser(Integer id) {
        if(userMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getUser(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user != null) {
            //TODO 封装返回的内容
            UserVO result = new UserVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listUser(UserListDTO dto, int pageNo, int pageSize) {
        Page<User> page = PageHelper.startPage(pageNo, pageSize);
        //List<User> users = userMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateUser(Integer id, UserUpdateDTO dto) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user != null) {
            //TODO 设值

            if(userMapper.updateByPrimaryKey(user) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}