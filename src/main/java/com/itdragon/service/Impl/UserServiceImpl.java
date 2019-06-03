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
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
    @Transactional//加上事务
    public void addUser(User user,String[] roleIds) {
        String userId = getUUID();       //生成用户的随机id
        user.setId(userId);
        userMapper.addUser(user);
        this.addUserRole(userId,roleIds);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    private void addUserRole(String userId,String[] roleIds) {
        if (roleIds == null) {
            return;
        }
        for (String roleId : roleIds) {
            userMapper.addUserRole(userId,roleId);
        }
    }

    @Override
    public void importData(List<List<String>> dataList, User user0) {
        for (List<String> strings : dataList) {
            User user = new User();
            String account = null;
            if (strings.get(0).contains("\n")) {
                account = strings.get(0).trim().replace("\n", "");
                user.setAccount(account);
            } else {
                account = strings.get(0).trim();
                user.setAccount(account);
            }

            if (strings.get(1).contains("\n")) {
                String username = strings.get(1).trim().replace("\n", "");
                user.setUsername(username);
            } else {
                user.setUsername(strings.get(1).trim());
            }

            if (strings.get(2).contains("\n")) {
                String iphone = strings.get(2).trim().replace("\n", "");
                user.setIphone(iphone);
            } else {
                user.setIphone(strings.get(2).trim());
            }

            if (strings.get(3).contains("\n")) {
                String email = strings.get(3).trim().replace("\n", "");
                user.setEmail(email);
            } else {
                user.setEmail(strings.get(3).trim());
            }

            if (!"".equals(account)&&this.findByName(account) == null) {
                this.addUser(user, null);
            } else {
                //提示用户该用户已存在
            }

        }

    }

    private String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }
}
