package com.yantumeijing.oline_class.service;

import com.yantumeijing.oline_class.model.entity.Video;
import com.yantumeijing.oline_class.model.entity.VideoBanner;

import java.util.List;
import java.util.concurrent.ExecutionException;

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
    List<VideoBanner> listBanner() throws ExecutionException;

    /**
     * 视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(int videoId);
}
