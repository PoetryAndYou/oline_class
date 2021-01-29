package com.yantumeijing.oline_class.mapper;

import com.yantumeijing.oline_class.model.entity.PlayRecord;

public interface PlayRecodeMapper {

    /**
     * 保存播放记录
     *
     * @param playRecord
     * @return
     */
    int savePalyRecode(PlayRecord playRecord);

}
