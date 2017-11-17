package com.sgm.b2c.service.impl;

import com.sgm.b2c.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/15.
 */
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void selectAllUser() throws Exception {
        System.out.println(userService.selectAllUser().toString());
    }

}