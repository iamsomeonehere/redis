package com.example.redis.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.redis.practice.dto.OrdersDto;
import com.example.redis.practice.service.RedisService;
import com.example.redis.practice.util.RedisUtils;

/**
 * @author rishi - created on 08/02/21
 **/
@Service
public class RedisServiceImpl implements RedisService {

  @Autowired
  private RedisTemplate<String, OrdersDto> ordersDtoRedisTemplate;

  @Autowired
  private RedisTemplate redisTemplate;

  @Override
  public void addData(String value) {
    redisTemplate.boundValueOps(value).set(String.valueOf(RedisUtils.getOrders()));
    System.out.println("String data cached into redis");
    String valueResult = (String) redisTemplate.opsForValue().get(value);
    System.out.println(valueResult);
  }

  @Override
  public OrdersDto redisObject(String key) {
    System.out.println(key);
    ordersDtoRedisTemplate.opsForValue().set(key, RedisUtils.getOrders());
    return ordersDtoRedisTemplate.opsForValue().get(key);
  }

  @Override
  @Cacheable(value = "orderdto", key = "#ordersDto.country", unless = "#result == null")
  public OrdersDto annotations(OrdersDto ordersDto) {
    System.out.println("Getting data from database");
    return RedisUtils.getOrders();
  }

  @Override
  @Cacheable(cacheNames = "addresses", keyGenerator = "customKeyGenerator", cacheManager = "cacheManager1")
  public String experiment(String v1, String v2) {
    System.out.println("Hitting database");
    return "RedisUtils.getOrders()";
  }

  @Override
  @CachePut(value = "addresses", key = "#v1")
  public String experimen(String v1) {
    System.out.println("Hitting database");
    return "changed";
  }
}
