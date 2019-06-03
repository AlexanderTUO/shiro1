package com.itdragon.pojo;

import lombok.Data;
import org.wuwz.poi.ExportConfig;

/**
 * @Author: itdragon
 * @Date: 2019/5/14 11:37
 * @Description:
 */
@Data
public class SysRole {
    private Integer id;
    @ExportConfig(value = "角色名称", width = 200)
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;
}
