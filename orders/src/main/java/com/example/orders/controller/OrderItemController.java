package com.example.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orders.data.OrderItem;
import com.example.orders.service.OrderItemService;

@RestController
@RequestMapping(path = "api/order-items")
public class OrderItemController {

  private final OrderItemService orderItemService;

  @Autowired
  public OrderItemController(OrderItemService orderItemService) {
    this.orderItemService = orderItemService;
  }

  @GetMapping
  public List<OrderItem> getOrderItems() {
    return orderItemService.getOrderItems();
  }

  @GetMapping(path = "{id}")
  public OrderItem getOrderItem(@PathVariable Long id) {
    return orderItemService.getOrderItem(id).get();
  }
  
  @PostMapping
  public void addNewOrderItem(@RequestBody OrderItem orderItem) {
    orderItemService.addNewOrderItem(orderItem);
  }

  @PutMapping(path = "{id}")
  public void updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
	  orderItem.setId(id);
	  if(orderItemService.getOrderItem(id).isPresent())
    orderItemService.updateOrderItem(orderItem);
  }
  
  @DeleteMapping(path = "{id}")
  public void deleteOrderItem(@PathVariable Long id) {
    orderItemService.deleteOrderItem(id);
  }

}