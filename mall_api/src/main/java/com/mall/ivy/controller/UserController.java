package com.mall.ivy.controller;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.user.UserListDTO;
import com.mall.ivy.dto.user.UserSaveDTO;
import com.mall.ivy.dto.user.UserUpdateDTO;
import com.mall.ivy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("")
    public Result save(@RequestBody UserSaveDTO dto) {
        return userService.saveUser(dto);
    }


    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody UserListDTO dto, int pageNo, int pageSize){
        return userService.listUser(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody UserUpdateDTO dto){
        return userService.updateUser(id, dto);
    }
}