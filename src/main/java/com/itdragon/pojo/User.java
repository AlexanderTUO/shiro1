package com.itdragon.pojo;

import lombok.Data;
import org.wuwz.poi.ExportConfig;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class User implements Serializable {
    @ExportConfig(value = "ID", width = 200)
    private String id;
    @ExportConfig(value = "登录用户", width = 200)
    private String account;
    @ExportConfig(value = "真实姓名", width = 200)
    private String username;
    private String plainPassword;//登录时的密码
    private String password;//加密后的密码
    private String salt;
    @ExportConfig(value = "电话", width = 200)
    private String iphone;
    @ExportConfig(value = "邮箱", width = 200)
    private String email;
    private String createDate;
    private String updateDate;
    private Integer status;

    private List<SysRole> roles;

    private Set<String> permissions;

//    public User(Integer id, String name, String password, XZQ xzq) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.xzq = xzq;
//    }
//
//    public User(Integer id, String name, String password) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//    }
}
