package cn.panyunyi.HealthyLifeMain.dao;

import cn.panyunyi.HealthyLifeMain.entity.MStepEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by panyu on 2018/5/7.
 */
public interface StepRepository extends BaseRepository<MStepEntity> {
    @SuppressWarnings("unchecked")
    public MStepEntity save(MStepEntity stepEntity);
    @Query("select m from MStepEntity m where m.userId=:userId")
    public MStepEntity findMStepEntityByUserId(@Param("userId")int userId);
}
