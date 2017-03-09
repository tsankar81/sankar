package com.infy.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.order.exception.ErrorResponse;
import com.infy.order.exception.OrderException;
import com.infy.order.model.Order;
import com.infy.order.service.OrderService;

@RestController
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	System.out.println("Jenkins Test");

	@RequestMapping(value = "/order/{orderNo}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity getOrderByNumber(@PathVariable String orderNo) {

		logger.info("orderNo====" + orderNo);
		Order order = orderService.findByOrderNo(orderNo);
		return new ResponseEntity(order, HttpStatus.OK);

	}

	@RequestMapping(value = "/order/ponumber/{poNumber}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity getOrderByPoNumber(@PathVariable String poNumber) {

		logger.info("poNumber====" + poNumber);

		Order order = orderService.findByPoNumber(poNumber);

		return new ResponseEntity(order, HttpStatus.OK);

	}

	@RequestMapping(value = "/order/customerid/{customerId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity getOrderByCustomerId(@PathVariable String customerId) {
		logger.info("customerId====" + customerId);
		Order order;

		order = orderService.findByCustomerId(customerId);
		return new ResponseEntity(order, HttpStatus.OK);

	}

	@RequestMapping(value = "/order/ordertype/{orderType}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity getOrderByType(@PathVariable String orderType) {
		logger.info("orderType====" + orderType);

		List<Order> order;
		try {
			order = orderService.findByOrderType(orderType);
		} catch (OrderException orderException) {
			logger.error(orderException.getMessage());
			return new ResponseEntity(orderException.toString(), HttpStatus.OK);
		}
		return new ResponseEntity(order, HttpStatus.OK);

	}

	@RequestMapping(value = "/order", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity getAllOrder() {

		logger.info("Inside getAllOrder====");

		List<Order> orderList = orderService.findAllOrder();
		logger.info("Inside getAllOrder orderList====" + orderList);
		return new ResponseEntity(orderList, HttpStatus.OK);

	}

	@RequestMapping(value = "/order", method = RequestMethod.POST, headers = "Accept=application/json")
	public void saveOrder(@RequestBody List<Order> order) {

		logger.info("Inside post method");
		orderService.saveOrder(order);

	}

	@RequestMapping(value = "/order", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateOrder(@RequestBody List<Order> order) {

		logger.info("Inside PUT method");
		orderService.updateOrder(order);

	}

	@RequestMapping(value = "/order/{orderNumber}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteOrder(@PathVariable String orderNumber) {

		logger.info("Inside Delete method");
		orderService.deleteOrder(orderNumber);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleExcecption(Exception exception) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);

	}

}
