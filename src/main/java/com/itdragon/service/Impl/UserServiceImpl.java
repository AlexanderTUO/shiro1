package com.itdragon.service.Impl;

import com.itdragon.bean.QueryBean;
import com.itdragon.dao.PermissionMapper;
import com.itdragon.dao.RoleMapper;
import com.itdragon.dao.UserMapper;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.SysPermission;
import com.itdragon.pojo.SysRole;
import com.itdragon.pojo.User;
import com.itdragon.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: itdragon
 * @Date: 2019/5/17 10:20
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    private static final transient Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl (UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Autowired
    public RoleMapper roleMapper;

    @Autowired
    public PermissionMapper permissionMapper;

    @Override
    public User add(User user){
        userMapper.add(user);
        return findById(user.getId());
    }

    @Override
    public User findById(String id){
        logger.info(id+"进入实现类获取数据！");
        User user = new User();
        user.setId(id);
        return userMapper.findOne(user);
    }

    @Override
    public User findByName(String name){
        User user = new User();
        user.setAccount(name);
        return userMapper.findOne(user);
    }

    @Override
    public List getUsers(QueryBean bean) {
        List<User> data = userMapper.getUsers(bean);
        //将角色和权限放入用户中
        for (User user : data) {
            //根据用户查询角色
            List<SysRole> roles = roleMapper.findRolesByAccount(user.getAccount());
            user.setRoles(roles);

            Set<String> permissionSet = new HashSet<>();
            //根据角色查询权限
            for (SysRole role : roles) {
                List<SysPermission> permissions = permissionMapper.findPermissionsByRole(role.getRole());
                for (SysPermission permission : permissions) {
                    permissionSet.add(permission.getPermission());
                }
            }
            user.setPermissions(permissionSet);
        }
        return data;
    }

    @Override
    public Result getPageUsers(QueryBean bean) {
        logger.info("用户列表查询：service");
        Result result = new Result();
        Integer records = userMapper.getRecordsCount(bean);
        List<User> data = getUsers(bean);

        result.setDraw(bean.getDraw());
        result.setRecordsTotal(records);
        result.setRecordsFiltered(records);
        result.setData(data);

        return result;
    }

    @Override
    public void deleteUsers(String[] ids) {
        for (String id : ids) {
            userMapper.deleteUser(id);
        }
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void addUserRole(String userId,String[] roleIds) {
        for (String roleId : roleIds) {
            userMapper.addUserRole(userId,roleId);
        }
    }


}
