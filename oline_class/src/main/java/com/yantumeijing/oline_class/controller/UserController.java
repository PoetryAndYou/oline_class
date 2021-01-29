package com.yantumeijing.oline_class.controller;

import com.yantumeijing.oline_class.model.entity.User;
import com.yantumeijing.oline_class.model.request.LoginRequest;
import com.yantumeijing.oline_class.service.UserService;
import com.yantumeijing.oline_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户接口
 */
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败！");
    }

    /**
     * 登录
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest) {
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        return token == null ? JsonData.buildError("登录失败，账号密码错误") : JsonData.buildSuccess(token);
    }

    /**
     * 通过token查询用户信息
     *
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");
        if (userId == null) {
            return JsonData.buildError("查询失败");
        }
        User user = userService.findUserInfoById(userId);
        return user == null ? JsonData.buildError("查询失败") : JsonData.buildSuccess(user);

    }
}
