package com.example.redis.practice.util;

import java.util.Date;

import com.example.redis.practice.dto.OrdersDto;

/**
 * @author rishi - created on 08/02/21
 **/
public class RedisUtils {

  public static OrdersDto getOrders() {
    return OrdersDto.builder()
        .address("Address")
        .birthDate(new Date())
        .city("City")
        .country("Mexico")
        .storeId("10001")
        .build();
  }
}
