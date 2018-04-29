package cn.panyunyi.HealthyLifeMain.service;


import cn.panyunyi.HealthyLifeMain.dao.DaoFactory;
import cn.panyunyi.HealthyLifeMain.entity.MUserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panyunyi on 2017/9/14.
 * CUFE cs14
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<MUserEntity> login(String userName) {
        {
            MUserEntity MUserEntity = new MUserEntity();
            MUserEntity.setUserName(userName);
            DaoFactory daoFactory = new DaoFactory();
            List<MUserEntity> MUserEntitylist = new ArrayList<>();
            try {
                MUserEntitylist = daoFactory.cursor(MUserEntity, "select * from m_user where m_user.userName='" + userName+ "'", MUserEntity.class);
                if (MUserEntitylist.size() == 0) {
                    MUserEntitylist = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return MUserEntitylist;
        }
    }

    @Override
    public List<MUserEntity> loginByUserId(String id) {
        MUserEntity MUserEntity = new MUserEntity();
        int i = Integer.parseInt(id);
        MUserEntity.setUserId(i);
        DaoFactory daoFactory = new DaoFactory();
        List<MUserEntity> MUserEntitylist = null;
        try {
            MUserEntitylist = daoFactory.cursor(MUserEntity, "select * from m_user where m_user.id=" + id + "", MUserEntity.class);
            if (MUserEntitylist.size() == 0) {
                MUserEntitylist = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return MUserEntitylist;
    }


    @Override
    public boolean register(MUserEntity MUserEntity) {
        DaoFactory daoFactory = new DaoFactory();
        boolean result = daoFactory.save(MUserEntity);

        return result;
    }

    @Override
    public boolean update(MUserEntity MUserEntity) {
        DaoFactory daoFactory = new DaoFactory();
        boolean result = daoFactory.update(MUserEntity);
        return result;
    }

}