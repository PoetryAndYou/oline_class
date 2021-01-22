package com.yantumeijing.oline_class.service;

import com.yantumeijing.oline_class.domain.User;

import java.util.Map;

public interface UserService {

    User findByPhone(String phone);

    int save(Map<String, String> userInfo);
}
