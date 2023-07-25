package com.example.orders.service;

import com.example.orders.data.Order;
import com.example.orders.data.OrderRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> getOrders() {
    return orderRepository.findAll();
  }
  
  public Optional<Order> getOrder(Long orderId) {
	    return orderRepository.findById(orderId);
	 }

  public void addNewOrder(Order order) {
    orderRepository.save(order);
  }

  public void updateOrder(Order order) {
	    orderRepository.save(order);
	  }
  
  public void deleteOrder(Long orderId) {
    orderRepository.deleteById(orderId);
  }
}
