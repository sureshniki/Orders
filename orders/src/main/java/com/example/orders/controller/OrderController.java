package com.example.orders.controller;

import com.example.orders.data.Order;
import com.example.orders.service.OrderService;

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

@RestController
@RequestMapping(path = "api/orders")
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping
  public List<Order> getOrders() {
    return orderService.getOrders();
  }

  @GetMapping(path = "{id}")
  public Order getOrder(@PathVariable Long id) {
    return orderService.getOrder(id).get();
  }
  
  @PostMapping
  public void addNewOrder(@RequestBody Order order) {
    orderService.addNewOrder(order);
  }

  @PutMapping(path = "{id}")
  public void updateOrder(@PathVariable Long id, @RequestBody Order order) {
	  order.setId(id);
	  if(orderService.getOrder(id).isPresent())
    orderService.updateOrder(order);
  }
  
  @DeleteMapping(path = "{id}")
  public void deleteOrder(@PathVariable Long id) {
    orderService.deleteOrder(id);
  }

}