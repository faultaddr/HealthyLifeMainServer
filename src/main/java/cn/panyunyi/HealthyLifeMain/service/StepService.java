package cn.panyunyi.HealthyLifeMain.service;

import cn.panyunyi.HealthyLifeMain.entity.MStepEntity;

import java.util.List;

/**
 * Created by panyu on 2018/5/2.
 */
public interface StepService {
    MStepEntity getStepByDate(String date);

    List<MStepEntity> getAllStepById(String id);

    List<MStepEntity> getAllUserStepData();

    String addStepData(MStepEntity mStepEntity);
}
