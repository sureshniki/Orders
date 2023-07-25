package com.example.orders.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderitems")
public class OrderItem {

  @Id
  @GeneratedValue
  private Long id;
  private String orderItemCategory;
  public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getOrderItemCategory() {
	return orderItemCategory;
}

public void setOrderItemCategory(String orderItemCategory) {
	this.orderItemCategory = orderItemCategory;
}

public String getOrderItemName() {
	return orderItemName;
}

public void setOrderItemName(String orderItemName) {
	this.orderItemName = orderItemName;
}

public Float getOrderItemPrice() {
	return orderItemPrice;
}

public void setOrderItemPrice(Float orderItemPrice) {
	this.orderItemPrice = orderItemPrice;
}

public Integer getOrderItemAmount() {
	return orderItemAmount;
}

public void setOrderItemAmount(Integer orderItemAmount) {
	this.orderItemAmount = orderItemAmount;
}

private String orderItemName;
  private Float orderItemPrice;
  private Integer orderItemAmount;
  
  @ManyToOne
  @JoinColumn(name="id")
  private Order order;
  
  public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public OrderItem() {

  }

  public OrderItem(Long id, String orderItemCategory, String orderItemName, Float orderItemPrice,
      Integer orderItemAmount) {
    this.id = id;
    this.orderItemCategory = orderItemCategory;
    this.orderItemName = orderItemName;
    this.orderItemPrice = orderItemPrice;
    this.orderItemAmount = orderItemAmount;
  }

  public OrderItem(String orderItemCategory, String orderItemName, Float orderItemPrice, Integer orderItemAmount) {
    this.orderItemCategory = orderItemCategory;
    this.orderItemName = orderItemName;
    this.orderItemPrice = orderItemPrice;
    this.orderItemAmount = orderItemAmount;
  }

@Override
public String toString() {
	return "OrderItem [id=" + id + ", orderItemCategory=" + orderItemCategory + ", orderItemName=" + orderItemName
			+ ", orderItemPrice=" + orderItemPrice + ", orderItemAmount=" + orderItemAmount + ", order=" + order + "]";
}




}
