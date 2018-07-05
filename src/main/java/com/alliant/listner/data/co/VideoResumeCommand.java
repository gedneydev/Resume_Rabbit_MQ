package com.alliant.listner.data.co;

import javax.validation.constraints.NotNull;

public class VideoResumeCommand {

    @NotNull
    private String customerToken;
    @NotNull
    private long lastPlayTime;
    @NotNull
    private long totalPlayTime;
    @NotNull
    private long videoId;

    @Override
    public String toString() {
        return "VideoResumeCommand{" +
                "customerToken='" + customerToken + '\'' +
                ", lastPlayTime=" + lastPlayTime +
                ", videoId=" + videoId +
                ", totalPlayTime="+ totalPlayTime +
                '}';
    }

    public String getCustomerToken() {
        return customerToken;
    }

    public void setCustomerToken(String customerToken) {
        this.customerToken = customerToken;
    }

    public long getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(long lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public long getTotalPlayTime() {
        return totalPlayTime;
    }

    public void setTotalPlayTime(long totalPlayTime) {
        this.totalPlayTime = totalPlayTime;
    }
}
