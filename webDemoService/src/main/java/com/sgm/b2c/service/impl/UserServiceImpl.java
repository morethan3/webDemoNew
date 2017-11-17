package com.sgm.b2c.service.impl;

import com.sgm.b2c.dao.UserDao;
import com.sgm.b2c.po.UserPO;
import com.sgm.b2c.service.UserService;
import com.sgm.b2c.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserPO selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public UserPO findByUsername(String name) {
        return userDao.findByUsername(name);
    }
}
