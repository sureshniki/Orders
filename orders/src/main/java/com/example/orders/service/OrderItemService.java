package com.example.orders.service;

import com.example.orders.data.OrderItem;
import com.example.orders.data.OrderItemRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

  private final OrderItemRepository orderItemRepository;

  @Autowired
  public OrderItemService(OrderItemRepository orderItemRepository) {
    this.orderItemRepository = orderItemRepository;
  }

  public List<OrderItem> getOrderItems() {
    return orderItemRepository.findAll();
  }
  
  public Optional<OrderItem> getOrderItem(Long orderItemId) {
	    return orderItemRepository.findById(orderItemId);
	 }

  public void addNewOrderItem(OrderItem orderItem) {
    orderItemRepository.save(orderItem);
  }

  public void updateOrderItem(OrderItem orderItem) {
	    orderItemRepository.save(orderItem);
	  }
  
  public void deleteOrderItem(Long orderItemId) {
    orderItemRepository.deleteById(orderItemId);
  }
}
