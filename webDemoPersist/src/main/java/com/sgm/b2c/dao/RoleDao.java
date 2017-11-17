package com.sgm.b2c.dao;

import com.sgm.b2c.po.RolePO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/17.
 */
public interface RoleDao {
    @Select("select * from t_web_role twr left join t_web_role_user_mapping twrum on twr.id = twrum.roleid where twrum.userid=#{userid}")
    List<RolePO> findByUserId(@Param("userid") String userId);

    @Select("select twr.role from t_web_role twr left join t_web_role_user_mapping twrum on twr.id = twrum.roleid where twrum.userid=#{userid}")
    List<String> findRoleByUserId(@Param("userid") String userId);

}
