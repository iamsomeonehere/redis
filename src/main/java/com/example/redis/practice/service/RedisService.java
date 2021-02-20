package com.example.redis.practice.service;

import com.example.redis.practice.dto.OrdersDto;

/**
 * @author rishi - created on 08/02/21
 **/
public interface RedisService {

  void addData(String value);

  OrdersDto redisObject(String key);

  OrdersDto annotations(OrdersDto ordersDto);

  String experiment(String v1, String v2);

  String experimen(String tomato);
}
