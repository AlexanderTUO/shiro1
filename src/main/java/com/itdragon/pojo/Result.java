package com.itdragon.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: tyk
 * @Date: 2019/5/21 10:23
 * @Description:
 */
@Data
public class Result implements Serializable {
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List data;
}
