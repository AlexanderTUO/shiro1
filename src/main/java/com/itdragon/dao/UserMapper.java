package com.itdragon.dao;

import com.itdragon.bean.QueryBean;
import com.itdragon.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int add(User user);
    User findOne(User user);

    Integer getRecordsCount(QueryBean bean);

    List getUsers(QueryBean bean);

    void deleteUser(String id);

    void addUser(User user);

    void updateUser(User user);

    void addUserRole(@Param("userId") String userId,@Param("roleId")String roleId);

}