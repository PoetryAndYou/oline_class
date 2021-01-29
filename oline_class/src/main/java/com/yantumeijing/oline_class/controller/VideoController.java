package com.yantumeijing.oline_class.controller;

import com.yantumeijing.oline_class.model.entity.Video;
import com.yantumeijing.oline_class.model.entity.VideoBanner;
import com.yantumeijing.oline_class.service.VideoService;
import com.yantumeijing.oline_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 公共的视频接口控制层
 */
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
     * 获取音频列表
     *
     * @return
     */
    @RequestMapping("list")
    public JsonData videoList() {
        List<Video> videos = videoService.videoList();
        return JsonData.buildSuccess(videos);
    }

    /**
     * 获取轮播图
     *
     * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner() throws ExecutionException {
        List<VideoBanner> bannerList = videoService.listBanner();
        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 视频详情
     *
     * @return
     */
    @GetMapping("find_detail_video")
    public JsonData findDetailById(@RequestParam(value = "video_id", required = true) int videoId) {
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }
}
