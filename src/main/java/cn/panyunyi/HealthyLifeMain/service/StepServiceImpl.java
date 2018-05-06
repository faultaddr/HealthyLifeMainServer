package cn.panyunyi.HealthyLifeMain.service;

import cn.panyunyi.HealthyLifeMain.dao.DaoFactory;
import cn.panyunyi.HealthyLifeMain.entity.MStepEntity;

import java.util.List;

/**
 * Created by panyu on 2018/5/2.
 */
public class StepServiceImpl implements StepService {
    private static StepServiceImpl newInstance = new StepServiceImpl();

    public static StepServiceImpl getInstance() {
        if (newInstance != null) {
            return newInstance;
        } else {
            return new StepServiceImpl();
        }
    }


    @Override
    public MStepEntity getStepByDate(String date) {
        String sql = "select * from m_step where m_step.currentDate='" + date + "'";
        List<MStepEntity> stepEntityList = optionHelper(sql);
        return stepEntityList == null ? null : stepEntityList.get(0);
    }

    @Override
    public List<MStepEntity> getAllStepById(String id) {
        String sql = "select * from m_step where m_step.id=" + id;
        return optionHelper(sql);
    }

    @Override
    public List<MStepEntity> getAllUserStepData() {
        String sql = "select * from m_step ";
        return optionHelper(sql);
    }

    @Override
    public String addStepData(MStepEntity stepEntity) {
        DaoFactory<MStepEntity> daoFactory = new DaoFactory<>();
        if (daoFactory.save(stepEntity)) {
            return "true";
        } else {
            return "false";
        }
    }

    private List<MStepEntity> optionHelper(String sql) {
        DaoFactory<MStepEntity> daoFactory = new DaoFactory<>();
        List<MStepEntity> mStepEntityList = null;
        try {
            mStepEntityList = daoFactory.cursor(sql, MStepEntity.class);
            if (mStepEntityList == null) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return mStepEntityList;
    }
}
