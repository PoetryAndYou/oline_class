package com.yantumeijing.oline_class.mapper;

import com.yantumeijing.oline_class.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoOrderMapper {

    /**
     * 查询用户是否购买此商品
     *
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    /**
     * 下单
     *
     * @param videoOrder
     * @return
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * 获取订单
     *
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(@Param("user_id") Integer userId);
}
