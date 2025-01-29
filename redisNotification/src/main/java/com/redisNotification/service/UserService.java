/*package com.redisNotification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RedisService redisService;

    public void cacheUserName(String name) {
        redisService.save("name", name);
    }

    public String getUserName() {
        return redisService.get("name");
    }
}*/