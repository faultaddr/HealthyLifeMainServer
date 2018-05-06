package cn.panyunyi.HealthyLifeMain.dao;

import cn.panyunyi.HealthyLifeMain.entity.MBeatEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * Created by panyunyi on 2018/5/6.
 */
@Repository
@Table(name = "m_beat")
@Qualifier("BeatRepository")
public interface  BeatRepository extends BaseRepository<MBeatEntity>{

    @SuppressWarnings("unchecked")
    public MBeatEntity save(MBeatEntity mBeatEntity);
    @Query("select m from MBeatEntity  m where m.userId=:userId")
    public MBeatEntity findMBeatEntityByUserId(@Param("userId")int userId);
}
