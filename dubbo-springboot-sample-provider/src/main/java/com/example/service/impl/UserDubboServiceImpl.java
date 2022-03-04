package com.example.service.impl;

import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Component;
import service.UserDubboService;


@Slf4j
@DubboService
@Component
public class UserDubboServiceImpl implements UserDubboService {
    @Override
    public User getUserInfo(long userId) {
        log.info("Request from consumer:{}", RpcContext.getServerContext().getRemoteAddress());
        log.info("Response from provider:{}", RpcContext.getServerContext().getLocalAddress());
        return new User(userId, "userNmae" + userId, "------>> Response from remote RPC provider:" + RpcContext.getServerContext().getLocalAddress());
    }

}
