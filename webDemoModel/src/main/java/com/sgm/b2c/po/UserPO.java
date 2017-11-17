package com.sgm.b2c.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/15.
 */
@Data
public class UserPO implements Serializable{
    private String id;
    private String uName;
    private String pwd;
    private Date cTime;
    private Date uTime;
}
