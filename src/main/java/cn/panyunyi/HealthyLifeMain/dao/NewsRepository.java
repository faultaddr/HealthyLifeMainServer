package cn.panyunyi.HealthyLifeMain.dao;

import cn.panyunyi.HealthyLifeMain.entity.MNewsEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

/**
 * Created by panyu on 2018/5/7.
 */
@Repository
@Table(name = "m_news")
@Qualifier("NewsRepository")
public interface NewsRepository extends BaseRepository<MNewsEntity> {
    @SuppressWarnings("unchecked")
    public MNewsEntity save(MNewsEntity entity);
    @Query("select m from MNewsEntity m")
    public List<MNewsEntity> getAll();

}
