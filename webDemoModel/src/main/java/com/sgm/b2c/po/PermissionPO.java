package com.sgm.b2c.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/17.
 */
@Data
public class PermissionPO implements Serializable{
    private String id;
    private String name;
    private String description;
    private String url;
    private String parentId;
    private String method;
    private Date cTime;
    private Date uTime;
}
