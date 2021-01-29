package com.yantumeijing.oline_class.mapper;

import com.yantumeijing.oline_class.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {

    Episode findFirstEpisodeById(@Param("video_id") int videoId);
}
