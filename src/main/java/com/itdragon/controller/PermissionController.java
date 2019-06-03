package com.itdragon.controller;

import com.itdragon.bean.QueryBean;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.SysPermission;
import com.itdragon.service.PermissionService;
import com.itdragon.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

/**
 * @Author: tyk
 * @Date: 2019/5/21 09:53
 * @Description:
 */
@Controller
@RequestMapping("/sys/permission")
public class PermissionController {

    @Autowired
    public PermissionService permissionService;

    @RequestMapping("")
    public String permission() {
        return "sysPermission/manageSysPermission";
    }

    /**
     * 列表展示
     * @param bean
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result employeeList(QueryBean bean) {
        return permissionService.getPermissions(bean);
    }

    @RequestMapping("/delete")
    @RequiresPermissions(value = "permission:delete")
    @ResponseBody
    public void deletePermission(@RequestParam(value = "ids")int[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            throw new InvalidParameterException("请选择要删除的行");
        }
        permissionService.deletePermissions(ids);
    }

    @RequestMapping("/add")
    @RequiresPermissions(value = "permission:add")
    @ResponseBody
    public void addPermission(@RequestBody SysPermission permission) {
        if (permission.getPermission() == null) {
            return;
        }
        permissionService.addPermission(permission);//添加用户信息
    }

    @RequestMapping("/update")
    @RequiresPermissions(value = "permission:update")
    @ResponseBody
    public void updatePermission(@RequestBody SysPermission permission) {
        if (permission.getPermission() == null) {
            return;
        }
        permissionService.updatePermission(permission);//添加用户信息
    }

    @RequestMapping("/view/{permissionId}")
    @ResponseBody
    public SysPermission findPermission(@PathVariable int permissionId) {
        return permissionService.findPermissionById(permissionId);
    }
}
