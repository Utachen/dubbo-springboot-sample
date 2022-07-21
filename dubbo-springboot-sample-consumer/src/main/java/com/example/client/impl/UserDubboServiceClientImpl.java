package com.example.client.impl;

import com.example.client.UserDubboServiceClient;
import entity.User;
import org.springframework.stereotype.Service;
import service.UserDubboService;


@Service
public class UserDubboServiceClientImpl implements UserDubboServiceClient {
    //@DubboReference(check = false,providedBy = {"kubernetes-apiserver-demo-provider"})
    private UserDubboService userDubboService;


    @Override
    public User getUserInfo(long userId) {
        return userDubboService.getUserInfo(userId);
    }

}
