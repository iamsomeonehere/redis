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

  private String customerName;
  private String contactName;
  private String address;
  private String city;
  private String postalCode;
  private String country;
  private Date orderDate;
  private String lastName;
  private String firstName;
  private Date birthDate;
  private String photo;
  private String notes;
  private int task;
  private String shipperName;
  private String phoneNumber;
  private int priority;
  private String storeId;
}
