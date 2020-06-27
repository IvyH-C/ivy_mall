package com.mall.ivy.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.redis.RedisService;
import com.mall.ivy.core.resp.PageVO;
import com.mall.ivy.dto.admin.AdminSaveDTO;
import com.mall.ivy.dto.admin.AdminUpdateDTO;
import com.mall.ivy.model.Admin;
import com.mall.ivy.model.AdminExample;
import com.mall.ivy.service.AdminService;
import com.mall.ivy.util.EmailUtil;
import com.mall.ivy.util.MD5Util;
import com.mall.ivy.vo.admin.AdminVO;
import com.mall.ivy.mapper.AdminMapper;

import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * AdminService实现
 * Created by Ivy.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    RedisService redisService;

    @Override
    public Result saveAdmin(AdminSaveDTO dto) {
        if(dto == null){
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        Admin admin = adminMapper.selectByAccountOrEmail(dto.getAccount(),dto.getEmail());
        if(admin != null){
            return ResultUtil.error(ResultEnum.DATA_EXISIS);
        }
        admin = new Admin();
        String MD5password = MD5Util.MD5Encode(dto.getPassword(), "UTF-8");
        admin.setSex(dto.getSex());
        admin.setTel(dto.getTel());
        admin.setPasswords(MD5password);
        admin.setName(dto.getName());
        admin.setEmail(dto.getEmail());
        admin.setAccount(dto.getAccount());
        admin.setDel(false);
        admin.setGmtCreate(new Date());
        admin.setGmtModify(new Date());
        if (adminMapper.insert(admin) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteAdmin(Integer id) {
        Admin admin = new Admin();
        admin.setGmtModify(new Date());
        if (adminMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getAdmin(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        if (admin == null) {
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        AdminVO result = new AdminVO();
        result.setAccount(admin.getAccount());
        result.setEmail(admin.getEmail());
        result.setName(admin.getName());
        result.setRole(admin.getRole());
        result.setSex(admin.getSex());
        result.setTel(admin.getTel());
        return ResultUtil.success(result);
    }

    @Override
    public Result listAdmin(int pageNo, int pageSize) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        //设置查询的条件：返回全部没有被删除的数据（del = 0）;
        criteria.andDelEqualTo(new Byte("0"));

        //这两行顺序不能变，中间也不能被其他代码插入；因为page行放在select的前面作用是：在拿数据的时候就已经分页拿了。
        Page<Admin> page = PageHelper.startPage(pageNo, pageSize);
        List<Admin> admins = adminMapper.selectByExample(example);

        PageVO pageVO = new PageVO();
        pageVO.setList(admins);
        pageVO.setRowCount(page.getTotal());
        return ResultUtil.success(pageVO);
    }

    @Override
    public Result updateAdmin(Integer id, AdminUpdateDTO dto) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        if(dto == null){
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
        admin.setAccount(dto.getAccount());
        admin.setEmail(dto.getEmail());
        admin.setName(dto.getName());
        admin.setPasswords(dto.getPasswords());
        admin.setRole(dto.getRole());
        admin.setTel(dto.getTel());
        admin.setSex(dto.getSex());
        admin.setGmtModify(new Date());
        if (adminMapper.updateByPrimaryKey(admin) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }


    @Override
    public Result sendVerifyEmail(String mailTo) {
        if (mailTo == null) {
            return ResultUtil.error(ResultEnum.EMAIL_EMPTY);
        }
        String mailCode = EmailUtil.sendVerifyEmail(mailTo);
        redisService.setKey(mailTo, mailCode, 1L);
        return ResultUtil.success();
    }
}