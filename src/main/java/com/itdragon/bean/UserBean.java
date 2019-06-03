package com.itdragon.bean;

import lombok.Data;

/**
 * @Author: tyk
 * @Date: 2019/5/24 15:31
 * @Description:
 */
@Data
public class UserBean {
    private String id;
    private String account;
    private String username;
    private String plainPassword;//登录时的密码
    private String password;//加密后的密码
    private String iphone;
    private String[] roleIds;//角色id
}
