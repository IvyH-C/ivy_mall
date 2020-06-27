package com.mall.ivy.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * adminUpdateDTO
 * Created by Ivy.
 */
@Data
public class AdminUpdateDTO {

    //字母开头，允许5-16字节，允许字母数字下划线
    @Pattern(regexp = "^[A-Za-z][A-Za-z1-9_-]+$")
    @NotNull
    private String name;

    @NotNull
    private String account;

    //检验13x、14x、15x、18x开头的手机号
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$")
    @NotNull
    private String tel;

    @NotNull
    private Byte role;

    //至少8个字符，至少1个大写字母，1个小写字母和1个数字,不能包含特殊字符（非数字字母）
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    @NotNull
    private String passwords;

    @NotNull
    private Byte sex;

    //域名外的内容只允许英文字母、数字、下划线、英文句号、以及中划线组成
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    @NotNull
    private String email;

    public AdminUpdateDTO() {
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

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
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



