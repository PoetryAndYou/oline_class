package com.yantumeijing.oline_class.mapper;

import com.yantumeijing.oline_class.domain.Video;
import com.yantumeijing.oline_class.domain.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * VideoMapper
 */
public interface VideoMapper {

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
     * 查看视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id")int videoId);
}
