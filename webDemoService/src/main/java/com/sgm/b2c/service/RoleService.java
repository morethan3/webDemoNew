package com.sgm.b2c.service;

import com.sgm.b2c.po.RolePO;

import java.util.List;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/17.
 */
public interface RoleService {
    List<RolePO> findByUserId(String userId);
    List<String> findRoleByUserId(String userId);
}
