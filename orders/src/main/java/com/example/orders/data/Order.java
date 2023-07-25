package com.example.orders.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue
  private Long id;
  private String orderCategory;
  private String orderName;
  private Float orderPrice;
  private Integer orderAmount;

  public Order() {

  }

  public Order(Long id, String orderCategory, String orderName, Float orderPrice,
      Integer orderAmount) {
    this.id = id;
    this.orderCategory = orderCategory;
    this.orderName = orderName;
    this.orderPrice = orderPrice;
    this.orderAmount = orderAmount;
  }

  public Order(String orderCategory, String orderName, Float orderPrice, Integer orderAmount) {
    this.orderCategory = orderCategory;
    this.orderName = orderName;
    this.orderPrice = orderPrice;
    this.orderAmount = orderAmount;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrderCategory() {
    return orderCategory;
  }

  public void setOrderCategory(String orderCategory) {
    this.orderCategory = orderCategory;
  }

  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }

  public Float getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(Float orderPrice) {
    this.orderPrice = orderPrice;
  }

  public Integer getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(Integer orderAmount) {
    this.orderAmount = orderAmount;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", orderCategory='" + orderCategory + '\'' +
        ", orderName='" + orderName + '\'' +
        ", orderPrice=" + orderPrice +
        ", orderAmount=" + orderAmount +
        '}';
  }

}
