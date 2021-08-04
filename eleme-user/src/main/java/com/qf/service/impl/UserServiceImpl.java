package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.utils.MD5Util;
import com.qf.utils.RedisUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    /**
     *
     */
    @Autowired
    private UserDao userDao;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public User findByUserName(String username) {
        User user = userDao.findByUserName(username);
        return user;
    }

    @Override
    public User findByUserTel(String tel) {
        User byUserTel = userDao.findByUserTel(tel);
        return byUserTel;
    }

    @Override
    public String addTel(String tel) {
        try {
            userDao.addTel(tel);
            return "success";
        } catch (Exception e) {
            e.getMessage();
        }
        return "fail";
    }

    @Override
    public String login(String tel, String code) {
        //根据手机号从redis取出验证码，进行比对
        Object userTelAndCode = redisUtils.hget("userTelAndCode", tel);
        if (userTelAndCode != null) {
            String s = (String) userTelAndCode;
            System.out.println(s);
            if (code.equals(s)) {

                return "success";
            } else {
                return "fail";
            }
        }
        return "fail";
    }

    @Override
    public String updateUserInfo(User user) {

        Integer update = userDao.update(user);
        if (update.equals(1)){
            User byUserTel = findByUserTel(user.getTel());
            //同步修改redis里的用户信息
            redisUtils.hset("user",byUserTel.getTel(),byUserTel);
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @Override
    public String updateUserPass(User user) {
        String pass = user.getPass();
//        String stringMD5 = MD5Util.getStringMD5(pass);
        //对原密码进行加密处理
        String newPass = new Md5Hash(pass, user.getTel(), 1024).toString();
        user.setPass(newPass);
        Integer update = userDao.update(user);
        if (update.equals(1)){
            User byUserTel = findByUserTel(user.getTel());
            //同步修改redis里的用户信息
            redisUtils.hset("user",byUserTel.getTel(),byUserTel);
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
}
