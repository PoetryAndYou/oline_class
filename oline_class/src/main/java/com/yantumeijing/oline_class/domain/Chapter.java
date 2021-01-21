package com.yantumeijing.oline_class.domain;

import java.util.Date;

/**
 * 章节对象
 */
public class Chapter {

    private Integer id;

    private Integer video_id;

    private String title;

    private Integer ordered;

    private Date create_time;

    public Chapter() {
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", video_id=" + video_id +
                ", title='" + title + '\'' +
                ", ordered=" + ordered +
                ", create_time=" + create_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
