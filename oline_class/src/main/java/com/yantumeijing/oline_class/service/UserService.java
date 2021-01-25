package com.yantumeijing.oline_class.service;

import com.yantumeijing.oline_class.model.entity.User;

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
     * 保存用信息
     *
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);

    /**
     * 登录
     * @param phone
     * @param pwd
     * @return
     */
    String findByPhoneAndPwd(String phone, String pwd);
}
