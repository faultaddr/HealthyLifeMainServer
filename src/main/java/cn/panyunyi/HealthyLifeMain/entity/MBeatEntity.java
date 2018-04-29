package cn.panyunyi.HealthyLifeMain.entity;

/**
 * Created by panyu on 2018/4/25.
 */
public class MBeatEntity {
    private String beats;
    private String curentDate;
    private String timeCount;
    private int userId;

    public String getBeats() {
        return beats;
    }

    public void setBeats(String beats) {
        this.beats = beats;
    }

    public String getCurentDate() {
        return curentDate;
    }

    public void setCurentDate(String curentDate) {
        this.curentDate = curentDate;
    }

    public String getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(String timeCount) {
        this.timeCount = timeCount;
    }

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

        MBeatEntity that = (MBeatEntity) o;

        if (userId != that.userId) return false;
        if (beats != null ? !beats.equals(that.beats) : that.beats != null) return false;
        if (curentDate != null ? !curentDate.equals(that.curentDate) : that.curentDate != null) return false;
        if (timeCount != null ? !timeCount.equals(that.timeCount) : that.timeCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = beats != null ? beats.hashCode() : 0;
        result = 31 * result + (curentDate != null ? curentDate.hashCode() : 0);
        result = 31 * result + (timeCount != null ? timeCount.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
