package com.itdragon.controller;

import com.itdragon.bean.QueryBean;
import com.itdragon.bean.UserBean;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.SysRole;
import com.itdragon.pojo.User;
import com.itdragon.service.RoleService;
import com.itdragon.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.UUID;

/**
 * @Author: tyk
 * @Date: 2019/5/21 09:53
 * @Description:
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    public RoleService roleService;

    @RequestMapping("")
    public String employee() {
        return "sysRole/manageSysRole";
    }

    /**
     * 列表展示
     * @param bean
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result employeeList(QueryBean bean) {
        return roleService.getRoles(bean);
    }

    @RequestMapping("/delete")
    @RequiresPermissions(value = "role:delete")
    @ResponseBody
    public void deleteRole(@RequestParam(value = "ids")int[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            throw new InvalidParameterException("请选择要删除的行");
        }
        roleService.deleteRoles(ids);
    }

    @RequestMapping("/add")
    @RequiresPermissions(value = "role:add")
    @ResponseBody
    public void addRole(@RequestBody SysRole role) {
        if (role.getRole() == null) {
            return;
        }
        roleService.addRole(role);//添加用户信息
    }

    @RequestMapping("/update")
    @RequiresPermissions(value = "role:update")
    @ResponseBody
    public void updateRole(@RequestBody SysRole role) {
        if (role.getRole() == null) {
            return;
        }
        roleService.updateRole(role);//添加用户信息
    }

    @RequestMapping("/view/{roleId}")
    @ResponseBody
    public SysRole findRole(@PathVariable int roleId) {
        return roleService.findRoleById(roleId);
    }
}
