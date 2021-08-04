package com.qf.adminservice;

import com.qf.pojo.Tb_Sys_User;
import com.qf.pojo.User;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
public interface AdminUserService {
    List<User> findAll();
    User updateUser(User user);
    String deleteById(Integer id);
    User findById(Integer id);
}
