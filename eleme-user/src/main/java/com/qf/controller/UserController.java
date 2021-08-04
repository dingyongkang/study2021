package com.qf.controller;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.utils.RandNum;
import com.qf.utils.RedisUtils;
import com.qf.utils.SmsApiHttpSendTest;
import org.apache.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    RandNum randNum;
     @Autowired
    HttpSession httpSession;
    //用户登录（手机号）
    public String loginByTel(String tel,String code){
        //登录业务
        String login = userService.login(tel, code);
        System.out.println(login);
        if (login.equals("success")){

            //登录成功后将用户信息存入redis
            User byUserTel = userService.findByUserTel(tel);
            redisUtils.hset("user",byUserTel.getTel(),byUserTel);
            return "登录成功";
        }else {
            return "验证码错误";
        }
    }
    //用户通过手机号和验证码登录
    @RequestMapping(value = "/comeIn/{tel}/{code}",method = RequestMethod.POST)
    public String comeIn(@PathVariable("tel") String tel, @PathVariable("code")String code){
        User byUserTel = userService.findByUserTel(tel);

        if (byUserTel!=null){
            return loginByTel(tel,code);

        }else {

            userService.addTel(tel);
            return loginByTel(tel,code);
        }
    }

    //用户通过用户名(或手机号)和密码登录
    @RequestMapping(value = "/login/{info}/{pass}",method = RequestMethod.POST)
    public String loginByName(@PathVariable("info")String info,@PathVariable("pass")String pass){
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(info,pass);
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()){
                Object user = redisUtils.hget("userInfo", info);
                Map map = JSONObject.parseObject(JSONObject.toJSONString(user), Map.class);
                String tel = map.get("tel").toString();
                redisUtils.hset("user",tel,user);
                redisUtils.hdel("userInfo",info);
                return "登录成功";
            }

        }catch (Exception e){
            redisUtils.hdel("userInfo",info);
            System.out.println(e.getMessage());
        }
        return "密码错误";
    }

    //获取验证码
    @RequestMapping(value = "/code/{tel}",method = RequestMethod.GET)
    public String getCode(@PathVariable("tel") String tel){
        //根据手机号获取验证码
        SmsApiHttpSendTest sh= new SmsApiHttpSendTest();
        String randNum = RandNum.createRandNum();
        try {
            sh.execute(tel,randNum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //将验证码和手机号存到redis,有效时间为2分钟
        redisUtils.hset("userTelAndCode",tel,randNum,120);
        //将验证码发送到手机号
        return randNum;
    }

    //修改用户信息
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateUserInfo(@RequestBody User user){
        //判断用户是否登录，并修改此手机号对应的用户名(前端修改信息里必须携带手机号，以区分不同用户)
        Object user1 = redisUtils.hget("user", user.getTel());
        if (user1!=null){
            return userService.updateUserInfo(user);
        }else {
            return "您还未登录，请先登录";
        }
    }
    //根据电话号码修改
    @RequestMapping(value = "/updatePass/{tel}",method = RequestMethod.POST)
    public User updateUserPass(@PathVariable("tel")String tel){
        //判断用户是否登录，并修改此手机号对应的用户名(前端修改信息里必须携带手机号，以区分不同用户)
        System.out.println("查询到了");
        Object obj = redisUtils.hget("user",tel);
        String s = JSONObject.toJSONString(obj);
        User user = JSONArray.parseObject(s, User.class);
        System.out.println(user);
        return  user;
    }


    @RequestMapping(value = "/changePass/{tel}/{pass}",method = RequestMethod.POST)
    public String updateUserPass1(@PathVariable("tel")String tel,@PathVariable("pass")String pass){
        //判断用户是否登录，并修改此手机号对应的用户名(前端修改信息里必须携带手机号，以区分不同用户)
        Object user1 = redisUtils.hget("user", tel);
        if (user1!=null){
            User user = new User();
            user.setTel(tel);
            user.setPass(pass);
            return userService.updateUserPass(user);
        }else {
            return "您还未登录，请先登录";

}}}