package service;

import entity.User;

public interface UserDubboService {
    User getUserInfo(long userId);
}
