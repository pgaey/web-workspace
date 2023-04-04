package com.kh.subway.model.vo;

import java.sql.Date;

// Data Transfer Object
// Value Object(불변 read-only)


public class Order {

	private String userName;	// USER_NAME VARCHAR2(20 BYTE)
	private String phone;		// PHONE VARCHAR2(13 BYTE)
	private String address;		// ADDRESS VARCHAR2(100 BYTE)
	private String message;		// MESSAGE VARCHAR2(200 BYTE)
	private String sandwich;	// SANDWICH VARCHAR2(50 BYTE)
	private String vegetable;	// VEGETABLE VARCHAR2(100 BYTE)
	private String sauce;		// SAUCE VARCHAR2(100 BYTE)
	private String cookie;		// COOKIE VARCHAR2(30 BYTE)
	private String payment;		// PAYMENT VARCHAR2(12 BYTE)
	private int price;			// PRICE NUMBER
	private Date orderDate;		// ORDER_DATE DATE
	
	public Order() {
		super();
	}

	public Order(String userName2, String phone2, String address2, String message2, String sandwich2, String string, String string2, String string3, String payment2, int price2, Object object) {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSandwich() {
		return sandwich;
	}

	public void setSandwich(String sandwich) {
		this.sandwich = sandwich;
	}

	public String getVegetable() {
		return vegetable;
	}

	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [userName=" + userName + ", phone=" + phone + ", address=" + address + ", message=" + message
				+ ", sandwich=" + sandwich + ", vegetable=" + vegetable + ", sauce=" + sauce + ", cookie=" + cookie
				+ ", payment=" + payment + ", price=" + price + ", orderDate=" + orderDate + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
