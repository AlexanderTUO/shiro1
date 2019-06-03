package com.itdragon.dao;

import com.itdragon.bean.QueryBean;
import com.itdragon.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: itdragon
 * @Date: 2019/5/14 14:32
 * @Description:
 */
@Mapper
public interface RoleMapper {

    List<SysRole> findRolesByAccount(String accout);

    List getRoles(QueryBean bean);

    Integer getRecordsCount(QueryBean bean);

    int addRole(SysRole role);

    int deleteRole(Integer roleId);

    int updateRole(SysRole role);

    SysRole findRoleById(Integer roleID);
}
