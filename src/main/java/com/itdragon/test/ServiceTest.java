package com.itdragon.test;

import com.itdragon.StartApplication;
import com.itdragon.pojo.SysPermission;
import com.itdragon.pojo.SysRole;
import com.itdragon.pojo.User;
import com.itdragon.service.PermissionService;
import com.itdragon.service.RoleService;
import com.itdragon.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: itdragon
 * @Date: 2019/5/17 11:00
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= StartApplication.class)
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Test
    public void findPermissionsByRole() {

        List<SysPermission> list = permissionService.findPermissionsByRole("admin");
    }

    @Test
    public void findByName() {

        User user = userService.findByName("admin");
    }

    @Test
    public void findRolesByAccout() {
        List<SysRole> list = roleService.findRolesByAccount("admin");
    }
}
