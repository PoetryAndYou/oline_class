package com.yantumeijing.oline_class.service.Impl;

import com.yantumeijing.oline_class.model.entity.Video;
import com.yantumeijing.oline_class.model.entity.VideoBanner;
import com.yantumeijing.oline_class.mapper.VideoMapper;
import com.yantumeijing.oline_class.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 视频接口业务层
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> videoList(){
        return videoMapper.videoList();
    }

    @Override
    public List<VideoBanner> listBanner() {
        return videoMapper.listBanner();
    }

    @Override
    public Video findDetailById(int videoId) {
        return videoMapper.findDetailById(videoId);
    }
}
