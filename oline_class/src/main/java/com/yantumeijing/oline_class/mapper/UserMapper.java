package com.yantumeijing.oline_class.mapper;

import com.yantumeijing.oline_class.model.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * userMapper
 */
public interface UserMapper {

    User findByPhone(@Param("phone") String phone);

    int save(User user);

    User findByPhoneAndPwd(@Param("phone")String phone, @Param("pwd")String pwd);
}
