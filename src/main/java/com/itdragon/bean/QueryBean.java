package com.itdragon.bean;

import lombok.Data;

/**
 * @Author: tyk
 * @Date: 2019/5/21 10:42
 * @Description:
 */
@Data
public class QueryBean {
    private Integer draw;
    private Integer start;
    private Integer length;
}
