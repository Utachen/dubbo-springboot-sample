package com.example.client;

import entity.User;

public interface UserDubboServiceClient {

    User getUserInfo(long userId);

}
