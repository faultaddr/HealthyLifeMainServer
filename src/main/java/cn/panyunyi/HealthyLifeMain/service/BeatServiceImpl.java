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
        String sql = "select * from m_beat where id=" + id;
        return optionHelper(sql);
    }

    @Override
    public List<MBeatEntity> getBeatsByDate(String date) {
        String sql = "select * from m_beat where currentDate='" + date + "%'";
        return optionHelper(sql);
    }

    @Override
    public boolean addBeats(MBeatEntity entity) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        daoFactory.save(entity);
        return false;
    }

    private List<MBeatEntity> optionHelper(String sql) {
        DaoFactory daoFactory = DaoFactory.getInstance();
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
