package com.atgui.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atgui.pojo.Cart;
import com.atgui.pojo.CartItem;
import com.atgui.service.impl.OrderServiceImpl;

public class OrderServiceTest {

	@Test
	public void testCreateOrder() {
		OrderServiceImpl order = new OrderServiceImpl();
		Cart Cart = new Cart();
			//public CartItem(Integer id, String name, Integer count, Double price,Double priceTotal)
			Cart.addItem(new CartItem(1, "aaa", 2, 200.0,200.0));
			Cart.addItem(new CartItem(2, "aaa", 2, 200.0,200.0));
			Cart.addItem(new CartItem(3, "ccc", 2, 200.0,200.0));
			System.out.println(Cart);
			String string = order.createOrder(Cart, 1);
			System.out.println(string );
	}

}
