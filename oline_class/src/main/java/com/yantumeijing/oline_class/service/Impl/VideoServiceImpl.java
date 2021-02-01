package com.yantumeijing.oline_class.service.Impl;

import com.yantumeijing.oline_class.config.CacheKeyMannger;
import com.yantumeijing.oline_class.exception.YTException;
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
        try {
            Object videoListObj = baseCache.getTenMinuteCache().get(CacheKeyMannger.INDEX_VIDEO_LIST, () -> {
                List<Video> videoList = videoMapper.videoList();
                return videoList;
            });
            if (videoListObj instanceof List) {
                List<Video> videoList = (List<Video>) videoListObj;
                return videoList;
            }
        } catch (Exception e) {
            throw new YTException(-1, "查询视频失败！");
        }
        //兜底数据，业务系统降级

        return null;
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
