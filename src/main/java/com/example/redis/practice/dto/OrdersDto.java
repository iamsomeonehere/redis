package com.example.redis.practice.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rishi - created on 08/02/21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersDto implements Serializable {

  private String address;
  private String city;
  private String country;
  private Date birthDate;
  private String storeId;
}
