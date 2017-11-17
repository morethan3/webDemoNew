package com.sgm.b2c.bo;

import lombok.Data;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/16.
 */
@Data
public class BaseResponseBO<T> {
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息描述
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

}
