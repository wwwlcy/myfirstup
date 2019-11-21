package com.atgui.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
public class Cart {
	private Map<Integer,CartItem> items=new HashMap<>();
	
	/*private Double totalCount;
	private Double totalPrice;*/
	
	public void addItem(CartItem item) {
		CartItem temp = items.get(item.getId());
		if(null!=temp) {
			Integer count = temp.getCount();
			temp.setCount(count+1);
			temp.setPriceTotal(temp.getPrice().multiply(new BigDecimal(temp.getCount())));
		}else {
			items.put(item.getId(), item);
			item.setPriceTotal(item.getPrice().multiply(new BigDecimal(item.getCount())));
		}
	}
	
	public BigDecimal updateItem(Integer id,Integer count) {
		if(items.containsKey(id)) {
			CartItem temp = items.get(id);
			temp.setCount(count);
			temp.setPriceTotal(temp.getPrice().multiply(new BigDecimal(temp.getCount())));
			return temp.getPriceTotal();
		}
		return null;
	}
	
	public void deleteItem(Integer id) {
		if(items.containsKey(id)) {
			items.remove(id);
		}
	}
	
	public void clearCart() {
		items.clear();
	}
	public Cart(Map<Integer, CartItem> map) {
		this.items = map;
	}
	public Cart() {
		super();
	}
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, CartItem> map) {
		this.items = map;
	}
	public Double getTotalCount() {
		Double totalCount=0.0;
		for (CartItem item : items.values()) {
			totalCount =totalCount+ item.getCount();
		}
		return totalCount;
	}
	
	public BigDecimal getTotalPrice() {
		BigDecimal totalPrice=new BigDecimal(0);
		for (CartItem item : items.values()) {
			totalPrice =totalPrice.add(item.getPriceTotal());
		}
		return totalPrice;
	}
	@Override
	public String toString() {
		return "Cart [map=" + items + ", totalCount=" + getTotalCount() + ", totalPrice=" + getTotalPrice() + "]";
	}
	

}
