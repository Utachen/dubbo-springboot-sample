package com.example.service;

import com.example.client.UserDubboServiceClient;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class trigger {

    @Autowired
    private UserDubboServiceClient userDubboServiceClient;

    private User user;
    @PostConstruct

    public void init() {
        try {
           this.user = userDubboServiceClient.getUserInfo(1);
        } catch (Exception e) {
            log.error("", e);
        }
        if (null != this.user) {
            log.info("" + user.getUserId());
        }
    }


}
