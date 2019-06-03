package com.itdragon.service.Impl;


import com.itdragon.bean.QueryBean;
import com.itdragon.dao.PermissionMapper;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.SysPermission;
import com.itdragon.pojo.SysRole;
import com.itdragon.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: itdragon
 * @Date: 2019/5/15 13:28
 * @Description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<SysPermission> findPermissionsByRole(String role) {
        return permissionMapper.findPermissionsByRole(role);
    }

    @Override
    public Result getPermissions(QueryBean bean) {
        Result result = new Result();
        Integer records = permissionMapper.getRecordsCount(bean);
        List<SysPermission> data = permissionMapper.getPermissions(bean);

        result.setDraw(bean.getDraw());
        result.setRecordsTotal(records);
        result.setRecordsFiltered(records);
        result.setData(data);

        return result;
    }

    @Override
    public int addPermission(SysPermission permission) {
        return permissionMapper.addPermission(permission);
    }

    @Override
    public int deletePermissions(int[] permissionIds) {
        int flag = 1;
        for (int permissionId : permissionIds) {
            if (permissionMapper.deletePermission(permissionId)<0) {
                flag = 0;
            }
        }
        return flag;
    }

    @Override
    public int updatePermission(SysPermission permission) {
        return permissionMapper.updatePermission(permission);
    }

    @Override
    public SysPermission findPermissionById(Integer permissionId) {
        return permissionMapper.findPermissionById(permissionId);
    }
}
