package cn.panyunyi.HealthyLifeMain.dao;

import cn.panyunyi.HealthyLifeMain.entity.MUserEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * Created by panyu on 2018/5/8.
 */

@Repository
@Table(name = "m_user")
@Qualifier("UserRepository")
public interface UserRepository extends BaseRepository<MUserEntity>{
    @SuppressWarnings("unchecked")
    public MUserEntity save(MUserEntity entity);
    @Query("select m from MUserEntity  m where m.userName=userName and m.userPassword=userPassword")
    public MUserEntity findMUserEntityByUserNameAndUserPassword(@Param("userName")String userName,@Param("userPassword")String userPassword);


}
