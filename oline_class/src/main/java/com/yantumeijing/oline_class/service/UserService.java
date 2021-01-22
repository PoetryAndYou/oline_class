package com.yantumeijing.oline_class.service;

import com.yantumeijing.oline_class.domain.User;

import java.util.Map;

public interface UserService {

    /**
     * 通过手机号查询用户
     *
     * @param phone
     * @return
     */
    User findByPhone(String phone);

    /**
     * 保存用信息S
     *
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);
}
