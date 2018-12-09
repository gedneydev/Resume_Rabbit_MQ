package com.alliant.listner.service;

import com.alliant.listner.config.AppConfig;
import com.alliant.listner.data.response.AuthResponse;
import com.alliant.listner.data.response.base.ApiResponse;
import com.alliant.listner.util.LRUCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.message.AuthException;

@Service
public class AuthService {

    @Autowired private AppConfig appConfig;
    @Autowired private LRUCache lruCache;

    public AuthResponse getAuthData(String token, String deviceToken) throws AuthException{
        if(lruCache.containsKey(token)) {
            System.out.println("Get auth details from cache");
            return lruCache.get(token);
        } else {
            System.out.println("get auth details from api call");
            AuthResponse authResponse = getAuthDataFromApi(token, deviceToken);
            lruCache.put(token, authResponse);
            return authResponse;
        }
    }

    private AuthResponse getAuthDataFromApi(String token, String deviceToken) throws AuthException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        if(deviceToken !=null)
            headers.set("Devicetoken",deviceToken);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<ApiResponse<AuthResponse>> response =  restTemplate.exchange(
                appConfig.getAuthUrl(), HttpMethod.GET, httpEntity, new ParameterizedTypeReference<ApiResponse<AuthResponse>>() {});
        System.out.println(response.getBody().toString());
        if(response.getBody().getResponseCode() == 200)
            return response.getBody().getResponseData();
        throw new AuthException();
    }
}
