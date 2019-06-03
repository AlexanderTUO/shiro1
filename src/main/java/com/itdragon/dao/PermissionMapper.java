package com.itdragon.dao;

import com.itdragon.bean.QueryBean;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: itdragon
 * @Date: 2019/5/15 13:30
 * @Description:
 */
@Mapper
public interface PermissionMapper {
    List<SysPermission> findPermissionsByRole(String role);

    List<SysPermission> getPermissions(QueryBean bean);

    Integer getRecordsCount(QueryBean bean);

    int addPermission(SysPermission permission);

    int deletePermission(int permissionId);

    int updatePermission(SysPermission permission);

    SysPermission findPermissionById(Integer permissionId);
}
