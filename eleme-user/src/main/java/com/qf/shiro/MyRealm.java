package com.qf.shiro;

import com.qf.adminservice.SysPermissionService;
import com.qf.adminservice.SysUserService;
import com.qf.pojo.Tb_Sys_Permission;
import com.qf.pojo.Tb_Sys_User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 54110 on 2019/11/22.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;
   //权限的
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String primaryPrincipal = (String)principalCollection.getPrimaryPrincipal();
        //登录名称查询该用户的权限
        List<Tb_Sys_Permission> userPermissionByUserName = sysPermissionService.findUserPermissionByUserName(primaryPrincipal);
      if (userPermissionByUserName!=null&&userPermissionByUserName.size()>0){
          //去重
          Collection list = new HashSet<>();
          for (Tb_Sys_Permission per :userPermissionByUserName
                  ) {
              list.add(per.getPer_name());
          }
          SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
          simpleAuthorizationInfo.addStringPermissions(list);
          return simpleAuthorizationInfo;
      }
        return null;
    }
    //登录的
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       //获取到当前登录的用户名
        String username = (String)authenticationToken.getPrincipal();
        //通过用户名去数据库查询正确的密码
        Tb_Sys_User user = sysUserService.findByUserName(username);
        if (user!=null){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getLogin_name(), user.getPassword(), getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
