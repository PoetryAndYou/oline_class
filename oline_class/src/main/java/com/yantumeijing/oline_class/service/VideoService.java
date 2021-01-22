package com.yantumeijing.oline_class.service;

import com.yantumeijing.oline_class.domain.Video;
import com.yantumeijing.oline_class.domain.VideoBanner;

import java.util.List;

public interface VideoService {

    /**
     * 查询视频列表
     * @return
     */
    List<Video> videoList();

    /**
     * 获取轮播图
     * @return
     */
    List<VideoBanner> listBanner();

    /**
     * 视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(int videoId);
}
