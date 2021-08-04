package com.qf.admincontroller;

import com.qf.adminservice.SysUserService;
import com.qf.adminservice.AdminUserService;
import com.qf.pojo.Tb_Sys_User;
import com.qf.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
@RestController
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private SysUserService sysUserService;
    //查询用户
//    @RequiresPermissions(value = {"user_find"})
    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public List<User> fandAll(){
        List<User> user = adminUserService.findAll();
        return user;
    }
    //修改用户
//    @RequiresPermissions(value = {"user_forbidden"})
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
     public User updateUser(@RequestBody User user){
        User user1 = adminUserService.updateUser(user);
        return user1;
    }
    //删除用户
    @RequiresPermissions(value = {"user_delete"})
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") Integer id){
        return adminUserService.deleteById(id);
    }
    //查询一个用户

    @RequestMapping(value = "/findOneUser/{id}",method = RequestMethod.GET)
    @RequiresPermissions(value = {"user_find"})
    public User findById(@PathVariable("id") Integer id){
        return adminUserService.findById(id);
    }
    //登陆
    @RequestMapping(value = "/dealLogin",method = RequestMethod.POST)
//    public String dealLogin(@RequestParam("username") String name,@RequestParam("password") String password){
    public String dealLogin(@RequestBody Tb_Sys_User user){
        System.out.println(user+"1111");
        String name = user.getLogin_name();
        String password = user.getPassword();
        System.out.println(name);

        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(name,password);
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                return "success";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "fail";
    }
    @RequestMapping("/unauth")
    public String unauth(){
        return "unauth";
    }
}
