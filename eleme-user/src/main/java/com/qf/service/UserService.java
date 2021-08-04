package com.qf.service;

import com.qf.pojo.User;

public interface UserService {
    User findByUserName(String username);
    User findByUserTel(String tel);
    String addTel(String tel);

    String login(String tel, String code);

    String updateUserInfo(User user);


    String updateUserPass(User user);
}
