package com.infy.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.order.exception.OrderException;
import com.infy.order.model.Order;
import com.infy.order.repository.OrderRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;

	@Override
	public Order findByOrderNo(String orderNo) {

		Order order = orderRepo.findOne(orderNo);
		return order;
	}

	@Override
	public Order findByPoNumber(String poNumber) {
		Order order = orderRepo.findByPonumber(poNumber);
		return order;
	}

	@Override
	public List<Order> findByOrderType(String orderType) throws OrderException {
		List<Order> order = orderRepo.findByOrdertype(orderType);
		System.out.println("order value in findByOrderType==" + order);
		System.out.println("order size  in findByOrderType==" + order.size());
		if (order == null || order.size() == 0)
			throw new OrderException("Order Not Found!!");
		return order;

	}

	@HystrixCommand(fallbackMethod = "circuitBreakerTest")
	@Override
	public Order findByCustomerId(String customerId) {
		Order order = orderRepo.findByCustomerid(customerId);
		return order;

	}

	@Override
	public List<Order> findAllOrder() {

		List<Order> orderList = (List<Order>) orderRepo.findAll();

		return orderList;
	}

	@Override
	public void saveOrder(List<Order> orders) {
		orderRepo.save(orders);
	}

	@Override
	public void deleteOrder(String orderNumber) {

		orderRepo.delete(orderNumber);
	}

	@Override
	public void updateOrder(List<Order> orders) {

		orderRepo.save(orders);
	}

	@Override
	public Order circuitBreakerTest(String customerId) {

		Order orderMock = new Order();

		orderMock.setOrderNumber("mockorderNo");
		orderMock.setCustomerId("mockCustomerId");
		orderMock.setOrderDate("mockorderdate");
		orderMock.setOrderType("mockordertype");

		return orderMock;
	}
}
