package cn.panyunyi.HealthyLifeMain.service;

import cn.panyunyi.HealthyLifeMain.entity.MBeatEntity;

import java.util.List;

/**
 * Created by panyunyi on 2018/5/3.
 */
public interface BeatService {
    List<MBeatEntity> getBeatsById(String id);

    List<MBeatEntity> getBeatsByDate(String date);

    boolean addBeats(MBeatEntity entity);
}
