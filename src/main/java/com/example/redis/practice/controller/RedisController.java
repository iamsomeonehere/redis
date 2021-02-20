package com.example.redis.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.practice.dto.OrdersDto;
import com.example.redis.practice.service.RedisService;
import com.example.redis.practice.util.RedisUtils;

/**
 * @author rishi - created on 08/02/21
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {

  @Autowired
  private RedisService redisService;

  @PostMapping("/putStringData")
  public String putData(@RequestParam String value) {
    redisService.addData(value);
    return "Done";
  }

  @PostMapping("/annotations")
  public OrdersDto annotations() {
    return redisService.annotations(RedisUtils.getOrders());
  }

  @PostMapping("/redisObject")
  public OrdersDto redisObject(@RequestParam String key) {
    return redisService.redisObject(key);
  }

  @PostMapping("/experiment")
  public String experiment(@RequestBody OrdersDto value) {
    System.out.println(redisService.experiment(value.getCity(), value.getCountry()));
    return "Done";
  }

  @PostMapping("/experimen")
  public String experimen(@RequestBody OrdersDto value) {
    System.out.println(redisService.experimen(value.getCity()));
    return "Done";
  }
}
