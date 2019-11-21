package com.atgui.test;

import org.junit.Test;

import com.atgui.pojo.Cart;
import com.atgui.pojo.CartItem;

public class CartTest {
	Cart Cart = new Cart();
	
	@Test
	public void testInteger() {
		Integer a1=new Integer(128);
		Integer a2=new Integer(128);
		System.out.println(a1==a2);
	}
	@Test
	public void testAddItem() {
		//public CartItem(Integer id, String name, Integer count, Double price,Double priceTotal)
		System.out.println(Cart);
		Cart.addItem(new CartItem(1, "aaa", 2, 200.0,200.0));
		Cart.addItem(new CartItem(2, "aaa", 2, 200.0,200.0));
		Cart.addItem(new CartItem(3, "ccc", 2, 200.0,200.0));
		System.out.println(Cart);
	}

	@Test
	public void testUpdateItem() {
		Cart.addItem(new CartItem(1, "aaa", 2, 200.0,200.0));
		Cart.addItem(new CartItem(2, "aaa", 2, 200.0,200.0  ));
		Cart.addItem(new CartItem(3, "ccc", 2, 200.0,200.0));
		Cart.updateItem(2, 8);
		System.out.println(Cart);
	}

	@Test
	public void testDeleteItem() {
		Cart.addItem(new CartItem(1, "aaa", 2, 200.0,200.0  ));
		Cart.addItem(new CartItem(2, "aaa", 2, 200.0,200.0 ));
		Cart.addItem(new CartItem(3, "aaa", 2, 200.0,200.0 ));
		Cart.deleteItem(1);
		System.out.println(Cart);
	}

	@Test
	public void testClearCart() {
		Cart.addItem(new CartItem(1, "aaa", 2, 200.0 ,200.0));
		Cart.addItem(new CartItem(2, "aaa", 2, 200.0,200.0 ));
		Cart.addItem(new CartItem(3, "aaa", 2, 200.0,200.0 ));
		Cart.clearCart();
		System.out.println(Cart);
	}

}
