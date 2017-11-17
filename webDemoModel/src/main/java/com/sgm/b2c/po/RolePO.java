package com.sgm.b2c.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/17.
 */
@Data
public class RolePO implements Serializable {
    private String id;
    private String role;
    private Date cTime;
    private Date uTime;
}
