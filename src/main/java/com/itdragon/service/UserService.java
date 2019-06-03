package com.itdragon.service;


import com.itdragon.bean.QueryBean;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @Author: itdragon
 * @Date: 2019/5/17 10:19
 * @Description:
 */
public interface UserService {
    User add(User user);

    @Cacheable(value="users", key="'user_'+#id")
    User findById(String id);

    User findByName(String name);


    Result getPageUsers(QueryBean bean);

    List getUsers(QueryBean bean);

    void deleteUsers(String[] ids);

    void addUser(User user,String[] roleIds);

    void updateUser(User user);


    void importData(List<List<String>> dataList, User user);
}
