package cn.panyunyi.HealthyLifeMain.entity;

/**
 * Created by panyu on 2018/4/25.
 */
public class MStepEntity {
    private String steps;
    private String currentDate;
    private int userId;

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
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

        MStepEntity that = (MStepEntity) o;

        if (userId != that.userId) return false;
        if (steps != null ? !steps.equals(that.steps) : that.steps != null) return false;
        if (currentDate != null ? !currentDate.equals(that.currentDate) : that.currentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = steps != null ? steps.hashCode() : 0;
        result = 31 * result + (currentDate != null ? currentDate.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
