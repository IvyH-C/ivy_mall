package com.mall.ivy.controller;

import com.mall.ivy.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mall.ivy.dto.admin.AdminSaveDTO;
import com.mall.ivy.dto.admin.AdminUpdateDTO;
import com.mall.ivy.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * AdminController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;


    /**
     * 注册管理人员
     * @param dto
     * @return
     */
    @PostMapping("")
    public Result save(@RequestBody AdminSaveDTO dto) {
        return adminService.saveAdmin(dto);
    }

    /**
     * 删除管理人员(逻辑删除)
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return adminService.deleteAdmin(id);
    }

    /**
     * 获取管理员个人资料
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return adminService.getAdmin(id);
    }

    /**
     * 获取全部管理人员
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public Result list(int pageNo, int pageSize){
        return adminService.listAdmin(pageNo, pageSize);
    }

    /**
     * 修改管理人员资料接口
     * @param id
     * @param dto
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody AdminUpdateDTO dto){
        return adminService.updateAdmin(id, dto);
    }

    /**
     * 发送邮箱验证码
     * @param mailTo
     * @return
     */
    @GetMapping("/sendMail")
    public Result sendVerifyEmail(@RequestParam String mailTo){
        return adminService.sendVerifyEmail(mailTo);
    }
}