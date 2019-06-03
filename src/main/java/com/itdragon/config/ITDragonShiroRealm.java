package com.itdragon.config;


import com.itdragon.pojo.SysPermission;
import com.itdragon.pojo.SysRole;
import com.itdragon.pojo.User;
import com.itdragon.service.PermissionService;
import com.itdragon.service.RoleService;
import com.itdragon.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: itdragon
 * @Date: 2019/5/14 11:44
 * @Description:
 */
public class ITDragonShiroRealm extends AuthorizingRealm {
    private static final transient Logger logger = LoggerFactory.getLogger(ITDragonShiroRealm.class);

    @Autowired
    public UserService userService;

    @Autowired
    public RoleService roleService;

    @Autowired
    public PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("-----------配置当前用户权限：");
        //从token中获取用户名
//        String username = (String) principals.getPrimaryPrincipal();

        //根据用户名获取用户信息
//        User user = userService.findByName(username);
        User user = (User)principals.getPrimaryPrincipal();

        if (user == null) {
            return null;
        }

        //给用户授权，先获取用户角色，在对各个角色授权

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        for(SysRole role:roleService.findRolesByAccount(user.getAccount())){
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission : permissionService.findPermissionsByRole(role.getRole())) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        logger.info("^^^^^^^^^^^^^^^^^^^^ ITDragon 认证用户身份信息");
        String username = (String) token.getPrincipal(); // 获取用户登录账号
        User userInfo = userService.findByName(username); // 通过账号查加密后的密码和盐，这里一般从缓存读取
        if(null == userInfo){
            return null;
        }
        // 1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = userInfo;
        // 2). credentials: 加密后的密码.
        Object credentials = userInfo.getPassword();
        // 3). realmName: 当前 realm 对象的唯一名字. 调用父类的 getName() 方法
        String realmName = getName();
        // 4). credentialsSalt: 盐值. 注意类型是ByteSource
        ByteSource credentialsSalt = ByteSource.Util.bytes(userInfo.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return info;
    }

}
