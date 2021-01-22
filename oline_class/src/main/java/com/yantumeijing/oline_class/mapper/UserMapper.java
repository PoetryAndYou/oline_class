package com.yantumeijing.oline_class.mapper;

import com.yantumeijing.oline_class.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findByPhone(@Param("phone") String phone);

    int save(User user);

}
