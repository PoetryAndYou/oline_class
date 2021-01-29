package com.yantumeijing.oline_class.service.Impl;

import com.yantumeijing.oline_class.config.CacheKeyMannger;
import com.yantumeijing.oline_class.model.entity.Video;
import com.yantumeijing.oline_class.model.entity.VideoBanner;
import com.yantumeijing.oline_class.mapper.VideoMapper;
import com.yantumeijing.oline_class.service.VideoService;
import com.yantumeijing.oline_class.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 视频接口业务层
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> videoList() {
        return videoMapper.videoList();
    }

    @Override
    public List<VideoBanner> listBanner() {
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyMannger.INDEX_BANNER_KEY, () -> {
                List<VideoBanner> bannerList = videoMapper.listBanner();
                return bannerList;
            });
            if (cacheObj instanceof List) {
                List<VideoBanner> videoBannerList = (List<VideoBanner>) cacheObj;
                return videoBannerList;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {
        return videoMapper.findDetailById(videoId);
    }
}
