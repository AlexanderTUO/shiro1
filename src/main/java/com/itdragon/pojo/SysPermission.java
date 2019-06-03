package com.itdragon.pojo;

import lombok.Data;

/**
 * @Author: itdragon
 * @Date: 2019/5/14 11:39
 * @Description:
 */
@Data
public class SysPermission {
    private Integer id;
    private String name;
    private String url;
    private String permission;
    private Boolean available = Boolean.FALSE;




}
