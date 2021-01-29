package com.yantumeijing.oline_class.service.Impl;

import com.yantumeijing.oline_class.model.entity.User;
import com.yantumeijing.oline_class.mapper.UserMapper;
import com.yantumeijing.oline_class.service.UserService;
import com.yantumeijing.oline_class.utils.CommontUtils;
import com.yantumeijing.oline_class.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * 用户业务层
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }

    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if (user != null) {
            return userMapper.save(user);
        } else {
            return -1;
        }
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone, CommontUtils.MD5(pwd));
        if (user != null) {
            String token = JWTUtils.geneJsonWebToken(user);
            return token;
        } else {
            return null;
        }
    }

    @Override
    public User findUserInfoById(Integer userId) {
        User user = userMapper.findUserInfoById(userId);
        return user;
    }

    /**
     * map转User对象
     *
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")) {
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            user.setPhone(userInfo.get("phone"));
            user.setPwd(CommontUtils.MD5(userInfo.get("pwd")));
            return user;
        }
        return null;
    }

    private static final String[] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg() {
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
