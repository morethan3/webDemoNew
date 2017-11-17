package com.sgm.b2c.service.impl;

import com.sgm.b2c.dao.RoleDao;
import com.sgm.b2c.po.RolePO;
import com.sgm.b2c.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/17.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RolePO> findByUserId(String userId) {
        return roleDao.findByUserId(userId);
    }

    @Override
    public List<String> findRoleByUserId(String userId) {
        return roleDao.findRoleByUserId(userId);
    }
}
