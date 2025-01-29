package com.redisNotification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Save key-value pair
    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // Retrieve value by key
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    // Delete a key
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}