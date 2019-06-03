package com.itdragon.service;


import com.itdragon.bean.QueryBean;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.SysPermission;
import com.itdragon.pojo.SysRole;

import java.util.List;

/**
 * @Author: itdragon
 * @Date: 2019/5/15 13:28
 * @Description:
 */
public interface PermissionService {
    List<SysPermission> findPermissionsByRole(String role);

    Result getPermissions(QueryBean bean);

    int addPermission(SysPermission permission);

    int deletePermissions(int[] permissionIds);

    int updatePermission(SysPermission permission);

    SysPermission findPermissionById(Integer permissionId);
}
