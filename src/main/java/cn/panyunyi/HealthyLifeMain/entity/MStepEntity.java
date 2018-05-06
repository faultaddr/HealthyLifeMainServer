package cn.panyunyi.HealthyLifeMain.entity;

import javax.persistence.*;

/**
 * Created by panyu on 2018/5/6.
 */
@Entity
@Table(name = "m_step", schema = "healthylifemain", catalog = "")
public class MStepEntity {
    private String steps;
    private String currentDateDetail;
    private int userId;

    @Basic
    @Column(name = "steps", nullable = true, length = 20)
    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    @Basic
    @Column(name = "currentDateDetail", nullable = true, length = 30)
    public String getCurrentDateDetail() {
        return currentDateDetail;
    }

    public void setCurrentDateDetail(String currentDateDetail) {
        this.currentDateDetail = currentDateDetail;
    }

    @Id
    @Column(name = "userId", nullable = false)
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

        MStepEntity that = (MStepEntity) o;

        if (userId != that.userId) return false;
        if (steps != null ? !steps.equals(that.steps) : that.steps != null) return false;
        if (currentDateDetail != null ? !currentDateDetail.equals(that.currentDateDetail) : that.currentDateDetail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = steps != null ? steps.hashCode() : 0;
        result = 31 * result + (currentDateDetail != null ? currentDateDetail.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
