package com.yantumeijing.oline_class.controller;

import com.yantumeijing.oline_class.model.entity.VideoOrder;
import com.yantumeijing.oline_class.model.request.VideoOrderRequest;
import com.yantumeijing.oline_class.service.VideoOrderService;
import com.yantumeijing.oline_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 订单
 */
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrdercontroller {

    @Autowired
    private VideoOrderService videoOrderService;

    /**
     * 下单
     *
     * @param videoOrderRequest
     * @param request
     * @return
     */
    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");
        int rows = videoOrderService.save(userId, videoOrderRequest.getVideoId());
        return rows > 0 ? JsonData.buildSuccess() : JsonData.buildError("下单失败");
    }

    /**
     * 订单列表
     *
     * @param request
     * @return
     */
    @GetMapping("list")
    public JsonData listOrder(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");
        List<VideoOrder> videoOrderList = videoOrderService.listOrderByUserId(userId);
        return JsonData.buildSuccess(videoOrderList);
    }
}
