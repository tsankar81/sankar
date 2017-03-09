package com.infy.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.order.model.Order;

public interface OrderRepository extends CrudRepository<Order, String> {

	public Order findByPonumber(String poNumber);

	public List<Order> findByOrdertype(String orderType);

	public Order findByCustomerid(String customerId);
}
