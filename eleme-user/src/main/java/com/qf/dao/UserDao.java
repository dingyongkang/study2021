package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User findByUserName(String username);
    User findByUserTel(String tel);
    String addTel(String tel);

    Integer update(User user);

}
