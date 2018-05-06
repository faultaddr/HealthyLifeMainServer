package cn.panyunyi.HealthyLifeMain.entity;

import javax.persistence.*;

/**
 * Created by panyu on 2018/5/6.
 */
@Entity
@Table(name = "m_news", schema = "healthylifemain", catalog = "")
public class MNewsEntity {
    private int newsId;
    private String imgUrl;
    private String linkUrl;
    private String description;

    @Id
    @Column(name = "newsId", nullable = false)
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "imgUrl", nullable = true, length = 20)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "linkUrl", nullable = true, length = 20)
    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MNewsEntity that = (MNewsEntity) o;

        if (newsId != that.newsId) return false;
        if (imgUrl != null ? !imgUrl.equals(that.imgUrl) : that.imgUrl != null) return false;
        if (linkUrl != null ? !linkUrl.equals(that.linkUrl) : that.linkUrl != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newsId;
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (linkUrl != null ? linkUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
