package com.sgm.b2c.service;

import com.sgm.b2c.po.UserPO;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/15.
 */
public interface UserService {

    UserPO selectAllUser();

    UserPO findByUsername(String name);
}
