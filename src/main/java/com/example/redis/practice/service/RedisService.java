package com.example.redis.practice.service;

import com.example.redis.practice.dto.OrdersDto;

/**
 * @author rishi - created on 08/02/21
 **/
public interface RedisService {

  void addData(String value);

  OrdersDto annotations(OrdersDto ordersDto);

  OrdersDto redisObject(String key);
}
