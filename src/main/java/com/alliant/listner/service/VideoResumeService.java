package com.alliant.listner.service;

import com.alliant.listner.data.co.VideoResumeCommand;
import com.alliant.listner.data.converter.CommandToDomainConverter;
import com.alliant.listner.data.response.AuthResponse;
import com.alliant.listner.domain.VideoResume;
import com.alliant.listner.repo.VideoResumeRepository;
import com.alliant.listner.util.LRUCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;

@Service
public class VideoResumeService {

    @Autowired private CommandToDomainConverter domainConverter;
    @Autowired private VideoResumeRepository videoResumeRepository;
    @Autowired private AuthService authService;

    public VideoResume saveUpdate(VideoResumeCommand command, String deviceToken) throws AuthException {
        AuthResponse authResponse = authService.getAuthData(command.getCustomerToken(), deviceToken);
        VideoResume obj = domainConverter.toDomain(command, authResponse);
        obj = videoResumeRepository.save(obj);
        return obj;
    }

}
