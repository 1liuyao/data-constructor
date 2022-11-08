package com.ly.pojo.RO;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class RequestStudyCenter {

    /**
     * clazzStatus : 0
     * subjectId : 0
     * platformType : 0
     * videoType : 0
     */

    private int clazzStatus;
    private int subjectId;
    private int platformType;
    private int videoType;

    public int getClazzStatus() {
        return clazzStatus;
    }

    public void setClazzStatus(int clazzStatus) {
        this.clazzStatus = clazzStatus;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getPlatformType() {
        return platformType;
    }

    public void setPlatformType(int platformType) {
        this.platformType = platformType;
    }

    public int getVideoType() {
        return videoType;
    }

    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }
}
