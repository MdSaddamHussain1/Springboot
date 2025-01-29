package com.redisNotification.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redisNotification.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/save")
    public String save(@RequestParam String key, @RequestParam String value) {
        redisService.save(key, value);
        return "Saved!";
    }

  
  /*  @GetMapping("/set")
    public String setKeyValue() {
        redisService.save("name", "zaman");
        return "Key 'name' set with value 'zaman'";
    }*/
    

    @GetMapping("/get")
    public String getKeyValue() {
        return redisService.get("new");
    }
    
    

    @DeleteMapping("/delete")
    public String delete(@RequestParam String key) {
        redisService.delete(key);
        return "Deleted!";
    }
}