package com.sgm.b2c.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/17.
 */
@Data
public class UserVO implements Serializable{
    private String id;
    private String userName;
    private String password;
    private List<RoleVO> roles;
}
