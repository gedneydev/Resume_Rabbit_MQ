package com.alliant.listner.data.converter;

import com.alliant.listner.data.co.VideoResumeCommand;
import com.alliant.listner.data.response.AuthResponse;
import com.alliant.listner.domain.VideoResume;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommandToDomainConverter {

    public VideoResume toDomain(VideoResumeCommand command, AuthResponse authResponse){
        VideoResume obj = new VideoResume(command.getVideoId(), authResponse.getUserId());
        obj.setPlayTime(command.getLastPlayTime());
        obj.setTotalPlayTime(command.getTotalPlayTime());
        obj.setEmail(authResponse.getEmail());
        obj.setcDate(new Date());
        return obj;
    }

}
