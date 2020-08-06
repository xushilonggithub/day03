package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

public class Content implements Serializable {
    @Id
    @Column(name = "contentId")
    private Integer contentid;

    @Column(name = "contentCategoryId")
    private Integer contentcategoryid;

    private String contenttile;

    private String contenurl;

    private String price;

    private String status;
@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return contentId
     */
    public Integer getContentid() {
        return contentid;
    }

    /**
     * @param contentid
     */
    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    /**
     * @return contentCategoryId
     */
    public Integer getContentcategoryid() {
        return contentcategoryid;
    }

    /**
     * @param contentcategoryid
     */
    public void setContentcategoryid(Integer contentcategoryid) {
        this.contentcategoryid = contentcategoryid;
    }

    /**
     * @return contenttile
     */
    public String getContenttile() {
        return contenttile;
    }

    /**
     * @param contenttile
     */
    public void setContenttile(String contenttile) {
        this.contenttile = contenttile == null ? null : contenttile.trim();
    }

    /**
     * @return contenurl
     */
    public String getContenurl() {
        return contenurl;
    }

    /**
     * @param contenurl
     */
    public void setContenurl(String contenurl) {
        this.contenurl = contenurl == null ? null : contenurl.trim();
    }

    /**
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contentid=").append(contentid);
        sb.append(", contentcategoryid=").append(contentcategoryid);
        sb.append(", contenttile=").append(contenttile);
        sb.append(", contenurl=").append(contenurl);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}