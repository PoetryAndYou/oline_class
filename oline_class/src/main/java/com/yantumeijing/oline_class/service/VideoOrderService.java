package com.yantumeijing.oline_class.service;

import com.yantumeijing.oline_class.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {

    /**
     * 保存订单
     *
     * @param userId
     * @param videoId
     * @return
     */
    int save(int userId, int videoId);

    /**
     * 获取我的订单
     *
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(Integer userId);
}
