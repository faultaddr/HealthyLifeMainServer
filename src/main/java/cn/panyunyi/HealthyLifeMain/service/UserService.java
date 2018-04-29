package cn.panyunyi.HealthyLifeMain.service;


import cn.panyunyi.HealthyLifeMain.entity.MUserEntity;

import java.util.List;

/**
 * Created by panyunyi on 2017/9/14.
 * CUFE cs14
 */
public interface UserService {

    List<MUserEntity> login(String id);

    List<MUserEntity> loginByUserId(String id);

    boolean register(MUserEntity userEntiy);

    boolean update(MUserEntity userEntity);
}