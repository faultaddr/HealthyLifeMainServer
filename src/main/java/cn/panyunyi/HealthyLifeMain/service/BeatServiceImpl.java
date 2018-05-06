package cn.panyunyi.HealthyLifeMain.service;

import cn.panyunyi.HealthyLifeMain.dao.DaoFactory;
import cn.panyunyi.HealthyLifeMain.entity.MBeatEntity;

import java.util.List;

/**
 * Created by panyu on 2018/5/3.
 */
public class BeatServiceImpl implements BeatService {
    private static BeatServiceImpl newInstance = new BeatServiceImpl();

    public static BeatServiceImpl getInstance() {
        if (newInstance != null) {
            return newInstance;
        } else {
            return new BeatServiceImpl();
        }
    }


    @Override
    public List<MBeatEntity> getBeatsById(String id) {
        String sql = "select * from m_beat where m_beat.id=" + id;
        return optionHelper(sql);
    }

    @Override
    public List<MBeatEntity> getBeatsByDate(String date) {
        String sql = "select * from m_beat where m_beat.currentDate='" + date + "%'";
        return optionHelper(sql);
    }

    @Override
    public boolean addBeats(MBeatEntity entity) {
        DaoFactory<MBeatEntity> daoFactory = new DaoFactory<>();
        return daoFactory.save(entity);
    }

    private List<MBeatEntity> optionHelper(String sql) {
        DaoFactory<MBeatEntity> daoFactory = new DaoFactory<>();
        List<MBeatEntity> mBeatEntityList = null;
        try {
            mBeatEntityList = daoFactory.cursor(sql, MBeatEntity.class);
            if (mBeatEntityList == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return mBeatEntityList;
    }
}
