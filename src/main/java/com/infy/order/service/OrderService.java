package com.infy.order.service;

import java.util.List;

import com.infy.order.exception.OrderException;
import com.infy.order.model.Order;

public interface OrderService {

	public Order findByOrderNo(String orderNo);

	public Order findByPoNumber(String poNumber);

	public List<Order> findByOrderType(String orderType) throws OrderException;

	public Order findByCustomerId(String customerId);

	public List<Order> findAllOrder();

	public void saveOrder(List<Order> orders);

	public void updateOrder(List<Order> orders);

	public void deleteOrder(String orderNumber);

	public Order circuitBreakerTest(String customerId);
}
