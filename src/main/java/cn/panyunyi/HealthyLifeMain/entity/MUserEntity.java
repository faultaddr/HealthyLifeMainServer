package cn.panyunyi.HealthyLifeMain.entity;

import javax.persistence.*;

/**
 * Created by panyu on 2018/5/6.
 */
@Entity
@Table(name = "m_user", schema = "healthylifemain", catalog = "")
public class MUserEntity {
    private String userName;
    private String userPassword;
    private String picSrc;
    private int userId;

    @Basic
    @Column(name = "userName", nullable = true, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "userPassword", nullable = true, length = 20)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "picSrc", nullable = true, length = 20)
    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc;
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

        MUserEntity that = (MUserEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (picSrc != null ? !picSrc.equals(that.picSrc) : that.picSrc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (picSrc != null ? picSrc.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
