package com.example.orders;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.orders.data.Order;
import com.example.orders.data.OrderItem;
import com.example.orders.data.OrderItemRepository;
import com.example.orders.data.OrderRepository;
import com.example.orders.service.OrderItemService;
import com.example.orders.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
class OrdersApplicationTests {

	 @InjectMocks
	 private OrderService orderService;
	 @InjectMocks
	 private OrderItemService orderItemService;
	 @Mock
	 private OrderRepository orderRepository;
	 @Mock
	 private OrderItemRepository orderItemRepository;
	 
		@BeforeEach
		void createMocks() {
	        MockitoAnnotations.initMocks(this);
         Order order1 = new Order();
         order1.setId(new Long(1));
         order1.setOrderAmount(100);
         order1.setOrderCategory("GROCERIES");
         order1.setOrderName("GROCERIES_ORDER");
         order1.setOrderPrice(new Float(150));
         OrderItem orderitem1 = new OrderItem();
         orderitem1.setId(new Long(1));
         orderitem1.setOrderItemAmount(100);
         orderitem1.setOrderItemCategory("GROCERIES");
         orderitem1.setOrderItemName("ATTA");
         orderitem1.setOrderItemPrice(new Float(150));
         orderitem1.setOrder(order1);
         Optional<Order> order = Optional.of(order1);
         Optional<OrderItem> orderItem = Optional.of(orderitem1);
         when(orderRepository.findById(new Long(1))).thenReturn(order);
         when(orderItemRepository.findById(new Long(1))).thenReturn(orderItem);         
         when(orderRepository.findAll()).thenReturn(List.of(order1));
         when(orderItemRepository.findAll()).thenReturn(List.of(orderitem1));
         //when(orderItemRepository.deleteById(new Long(1)))      
		}

		@Test
		void getOrder() {
			Optional<Order> order = orderService.getOrder(new Long(1));
			assertEquals(order.get()!=null, true);
		}
		
		@Test
		void getOrders() {
			List<Order> list = orderService.getOrders();
			assertEquals(list.size()>0, true);
		}
		
		@Test
		void createOrders() {
			Order order1 = new Order();
	         order1.setId(new Long(1));
	         order1.setOrderAmount(100);
	         order1.setOrderCategory("GROCERIES");
	         order1.setOrderName("GROCERIES_ORDER");
	         order1.setOrderPrice(new Float(150));
			assertDoesNotThrow(() -> orderService.addNewOrder(order1));
		}
		
		@Test
		void updateOrders() {
			Order order1 = new Order();
	         order1.setId(new Long(1));
	         order1.setOrderAmount(100);
	         order1.setOrderCategory("GROCERIES");
	         order1.setOrderName("GROCERIES_ORDER");
	         order1.setOrderPrice(new Float(150));
			assertDoesNotThrow(() -> orderService.updateOrder(order1));
		}
		
		@Test
		void deleteOrders() {
			assertDoesNotThrow(() -> orderService.deleteOrder(new Long(1)));
		}	

        @Test
		void getOrderItem() {
			Optional<OrderItem> order = orderItemService.getOrderItem(new Long(1));
			assertEquals(order.get()!=null, true);
		}
		
		@Test
		void getOrderItems() {
			List<OrderItem> list = orderItemService.getOrderItems();
			assertEquals(list.size()>0, true);
		}
		
		@Test
		void createOrderItems() {
			OrderItem orderItem1 = new OrderItem();
	         orderItem1.setId(new Long(1));
	         orderItem1.setOrderItemAmount(100);
	         orderItem1.setOrderItemCategory("GROCERIES");
	         orderItem1.setOrderItemName("GROCERIES_ORDER");
	         orderItem1.setOrderItemPrice(new Float(150));
			assertDoesNotThrow(() -> orderItemService.addNewOrderItem(orderItem1));
		}
		
		@Test
		void updateOrderItems() {
			OrderItem orderItem1 = new OrderItem();
	         orderItem1.setId(new Long(1));
	         orderItem1.setOrderItemAmount(100);
	         orderItem1.setOrderItemCategory("GROCERIES");
	         orderItem1.setOrderItemName("GROCERIES_ORDER");
	         orderItem1.setOrderItemPrice(new Float(150));
			assertDoesNotThrow(() -> orderItemService.updateOrderItem(orderItem1));
		}
		
		@Test
		void deleteOrderItems() {
			assertDoesNotThrow(() -> orderItemService.deleteOrderItem(new Long(1)));
		}	

}
