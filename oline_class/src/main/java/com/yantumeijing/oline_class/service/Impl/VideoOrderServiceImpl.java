package com.yantumeijing.oline_class.service.Impl;

import com.yantumeijing.oline_class.exception.YTException;
import com.yantumeijing.oline_class.mapper.EpisodeMapper;
import com.yantumeijing.oline_class.mapper.PlayRecodeMapper;
import com.yantumeijing.oline_class.mapper.VideoMapper;
import com.yantumeijing.oline_class.mapper.VideoOrderMapper;
import com.yantumeijing.oline_class.model.entity.Episode;
import com.yantumeijing.oline_class.model.entity.PlayRecord;
import com.yantumeijing.oline_class.model.entity.Video;
import com.yantumeijing.oline_class.model.entity.VideoOrder;
import com.yantumeijing.oline_class.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin.util.UIUtil;

import javax.xml.crypto.Data;
import java.beans.Transient;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 订单
 */
@Service
@Transactional
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecodeMapper playRecodeMapper;

    /**
     * 下单
     *
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    public int save(int userId, int videoId) {
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);
        if (null != videoOrder) {
            return 0;
        }
        Video video = videoMapper.findById(videoId);
        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString().replace("-", ""));
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());
        int rows = videoOrderMapper.saveOrder(newVideoOrder);
        if (rows == 1) {
            Episode episode = episodeMapper.findFirstEpisodeById(videoId);
            if (null == episode) {
                throw new YTException(-1, "视频没有数据，请联系管理员！");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecodeMapper.savePalyRecode(playRecord);
        }
        return rows;
    }

    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {
        return videoOrderMapper.listOrderByUserId(userId);
    }
}
