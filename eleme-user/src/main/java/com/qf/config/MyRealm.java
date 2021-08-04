package com.qf.config;

import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.utils.RedisUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    RedisUtils redisUtils;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object primaryPrincipal = principals.getPrimaryPrincipal();

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();

        User user = userService.findByUserName(principal);
        if (user == null) {
            user = userService.findByUserTel(principal);
        }

        if (user != null) {

            String tel = user.getTel();

            //当前realm对象的name
            String realmName = getName();
            //盐值
            ByteSource bytes = ByteSource.Util.bytes(user.getTel());

            //登录成功后将用户信息存入redis
            redisUtils.hset("userInfo", principal, user);

            //封装用户信息，构建AuthenticationInfo对象并返回
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(principal, user.getPass(), bytes,realmName);
            return authcInfo;

        }
        return null;
    }
}
