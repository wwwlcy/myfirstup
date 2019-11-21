package com.atgui.pojo;

import java.math.BigDecimal;

public class OrderItem {
	private Integer id;//数据库id
	private String name;//商品名称
	private Integer count; //商品数量
	private BigDecimal price; //商品单价
	private BigDecimal totalPrice; //商品总价
	private String orderId; //订单号
	
	public OrderItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice, String orderId) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.price = price;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
	}
	
	public OrderItem() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", name=" + name + ", count=" + count + ", price=" + price + ", totalPrice="
				+ totalPrice + ", orderId=" + orderId + "]";
	}
	
}
