package cn.panyunyi.HealthyLifeMain.entity;

import javax.persistence.*;

/**
 * Created by panyu on 2018/5/6.
 */
@Entity
@Table(name = "m_beat", schema = "healthylifemain", catalog = "")
public class MBeatEntity {
    private String beats;
    private String currentDateDetail;
    private String timeCount;
    private int userId;

    @Basic
    @Column(name = "beats", nullable = true, length = 20)
    public String getBeats() {
        return beats;
    }

    public void setBeats(String beats) {
        this.beats = beats;
    }

    @Basic
    @Column(name = "current_date_detail", nullable = true, length = 30)
    public String getCurrentDateDetail() {
        return currentDateDetail;
    }

    public void setCurrentDateDetail(String currentDateDetail) {
        this.currentDateDetail = currentDateDetail;
    }

    @Basic
    @Column(name = "time_count", nullable = true, length = 20)
    public String getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(String timeCount) {
        this.timeCount = timeCount;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MBeatEntity entity = (MBeatEntity) o;

        if (userId != entity.userId) return false;
        if (beats != null ? !beats.equals(entity.beats) : entity.beats != null) return false;
        if (currentDateDetail != null ? !currentDateDetail.equals(entity.currentDateDetail) : entity.currentDateDetail != null)
            return false;
        if (timeCount != null ? !timeCount.equals(entity.timeCount) : entity.timeCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = beats != null ? beats.hashCode() : 0;
        result = 31 * result + (currentDateDetail != null ? currentDateDetail.hashCode() : 0);
        result = 31 * result + (timeCount != null ? timeCount.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
