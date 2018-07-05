package com.alliant.listner.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class VideoResumeId implements Serializable {

    @NotNull
    private Long userId;

    @NotNull
    private Long videoId;

    public VideoResumeId(){}

    public VideoResumeId(long videoId, long userId) {
        this.videoId=videoId;
        this.userId=userId;
    }

    @Override
    public String toString() {
        return "VideoResumeId{" +
                "userId=" + userId +
                ", videoId=" + videoId +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }
}
