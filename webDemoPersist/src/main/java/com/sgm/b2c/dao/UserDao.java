package com.sgm.b2c.dao;

import com.sgm.b2c.po.UserPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/15.
 */
public interface UserDao {
    @Select("select * from t_web_user")
    UserPO selectAllUser();
    @Select("select * from t_web_user where uname=#{uname}")
    UserPO findByUsername(@Param("uname") String name);
}
