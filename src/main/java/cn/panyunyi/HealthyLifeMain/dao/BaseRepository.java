package cn.panyunyi.HealthyLifeMain.dao;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by panyu on 2018/5/7.
 */
public interface BaseRepository<T> extends CrudRepository<T,Long> {
}
