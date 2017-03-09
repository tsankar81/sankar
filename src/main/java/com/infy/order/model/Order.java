package com.infy.order.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ordertest")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Order() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String ordernumber;

	@Column
	private String orderdate;

	@Column
	private String ordertype;

	@Column
	private String customerid;

	@Column
	private String ponumber;

	@Column
	private String showstatuscode;

	@Column
	private String showorderstatusmessage;

	public String getOrderNumber() {
		return ordernumber;
	}

	public String getOrderDate() {
		return orderdate;
	}

	public String getOrderType() {
		return ordertype;
	}

	public String getCustomerId() {
		return customerid;
	}

	public String getPoNumber() {
		return ponumber;
	}

	public String getShowstatusCode() {
		return showstatuscode;

	}

	public String getShowOrderstatusMessage() {
		return showorderstatusmessage;

	}

	public void setOrderNumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public void setOrderDate(String orderdate) {
		this.orderdate = orderdate;
	}

	public void setOrderType(String ordertype) {
		this.ordertype = ordertype;
	}

	public void setCustomerId(String customerid) {
		this.customerid = customerid;
	}

	public void setPoNumber(String ponumber) {
		this.ponumber = ponumber;
	}

	public void setShowstatusCode(String showstatuscode) {
		this.showstatuscode = showstatuscode;
	}

	public void setShowOrderstatusMessage(String showorderstatusmessage) {
		this.showorderstatusmessage = showorderstatusmessage;
	}
}
