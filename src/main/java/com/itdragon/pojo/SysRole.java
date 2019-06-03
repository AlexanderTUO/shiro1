package com.itdragon.pojo;

import lombok.Data;

/**
 * @Author: itdragon
 * @Date: 2019/5/14 11:37
 * @Description:
 */
@Data
public class SysRole {
    private Integer id;
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;
}
