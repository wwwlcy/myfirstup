package com.atgui.pojo;

import java.math.BigDecimal;

public class CartItem {
	private Integer id;
	private String name;
	private Integer count;
	private BigDecimal price;
	private BigDecimal priceTotal;
	
	public CartItem() {
		super();
	}

	public CartItem(Integer id, String name, Integer count, Double price,Double priceTotal) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.price = new BigDecimal(price+"");
		this.priceTotal = new BigDecimal(priceTotal+"");
	}
	
	
	public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal priceTotal) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.price = price;
		this.priceTotal = priceTotal;
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

	public BigDecimal getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(BigDecimal priceTotal) {
		this.priceTotal = priceTotal;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", count=" + count + ", price=" + price + ", priceTotal="
				+ priceTotal + "]";
	}
	
	

}
