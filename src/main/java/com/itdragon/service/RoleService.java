package com.itdragon.service;


import com.itdragon.bean.QueryBean;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.SysRole;

import java.util.List;

/**
 * @Author: itdragon
 * @Date: 2019/5/14 14:32
 * @Description:
 */
public interface RoleService {

    List<SysRole> findRolesByAccount(String account);

    Result getRoles(QueryBean bean);

    int addRole(SysRole role);

    int deleteRoles(int[] roleId);

    int updateRole(SysRole role);

    SysRole findRoleById(Integer roleID);
}
