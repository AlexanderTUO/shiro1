package com.itdragon.service.Impl;


import com.itdragon.bean.QueryBean;
import com.itdragon.dao.RoleMapper;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.SysPermission;
import com.itdragon.pojo.SysRole;
import com.itdragon.pojo.User;
import com.itdragon.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: itdragon
 * @Date: 2019/5/14 14:32
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    public RoleMapper roleMapper;

    @Override
    public List<SysRole> findRolesByAccount(String account) {
        return roleMapper.findRolesByAccount(account);
    }

    @Override
    public Result getRoles(QueryBean bean) {
        Result result = new Result();
        Integer records = roleMapper.getRecordsCount(bean);
        List<SysRole> data = roleMapper.getRoles(bean);

        result.setDraw(bean.getDraw());
        result.setRecordsTotal(records);
        result.setRecordsFiltered(records);
        result.setData(data);

        return result;
    }


    @Override
    public int addRole(SysRole role) {
        return roleMapper.addRole(role);
    }


    @Override
    public int deleteRoles(int[]  roleIds) {
        int flag = 1;
        for (int roleId : roleIds) {
            if (roleMapper.deleteRole(roleId)<0) {
                flag = 0;
            }
        }
        return flag;
    }

    @Override
    public int updateRole(SysRole role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public SysRole findRoleById(Integer roleID) {
        return roleMapper.findRoleById(roleID);
    }
}
