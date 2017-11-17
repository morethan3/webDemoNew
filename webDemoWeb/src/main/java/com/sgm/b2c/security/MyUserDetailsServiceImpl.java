package com.sgm.b2c.security;

import com.sgm.b2c.po.UserPO;
import com.sgm.b2c.service.RoleService;
import com.sgm.b2c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Created by Li B
 * on 2017/2/20.
 */
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 根据用户名获取登录用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username){
        UserPO user = userService.findByUsername(username);

        if(user == null){
             throw new UsernameNotFoundException("用户名："+ username + "不存在！");
        }

        Collection<SimpleGrantedAuthority> collection = new HashSet<>();
        List<String> roles = roleService.findRoleByUserId(user.getId());
        for (String role : roles) {
            collection.add(new SimpleGrantedAuthority(role));
        }
        return new User(username,user.getPwd(),collection);
    }
}
