package com.alliant.listner.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "video_resume")
public class VideoResume {

    @EmbeddedId
    private VideoResumeId id;

    @Column(name = "email")
    private String email;


    @Column(name = "play_time")
    private long playTime;

    @Column(name = "total_play_time")
    private long totalPlayTime;

    @Column(name = "cdate")
    private Date cDate;


    public VideoResume(){}

    public VideoResume(long videoId, long userId) {
        id = new VideoResumeId(videoId, userId);
    }

    @Override
    public String toString() {
        return "VideoResume{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", playTime=" + playTime +
                ", cDate=" + cDate +
                '}';
    }


    public VideoResumeId getId() {
        return id;
    }

    public void setId(VideoResumeId id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPlayTime() {
        return playTime;
    }

    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public long getTotalPlayTime() {
        return totalPlayTime;
    }

    public void setTotalPlayTime(long totalPlayTime) {
        this.totalPlayTime = totalPlayTime;
    }
}
