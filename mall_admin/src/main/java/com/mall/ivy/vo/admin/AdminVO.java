package com.mall.ivy.vo.admin;

import lombok.Data;

import java.util.List;

/**
* admin详情
* Created by Ivy.
*/
@Data
public class AdminVO {
    private String name;

    private String account;

    private String tel;

    private Byte role;

    private Byte sex;

    private String email;

    public AdminVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}