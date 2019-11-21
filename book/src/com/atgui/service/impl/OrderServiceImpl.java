package com.atgui.service.impl;
import java.util.Date;

import com.atgui.daoimpl.BookDaoImpl;
import com.atgui.daoimpl.OrderDaoImpl;
import com.atgui.daoimpl.OrderItemDaoImpl;
import com.atgui.pojo.Book;
import com.atgui.pojo.Cart;
import com.atgui.pojo.CartItem;
import com.atgui.pojo.Order;
import com.atgui.pojo.OrderItem;
public class OrderServiceImpl implements OrderService {
	private OrderDaoImpl orderDao = new OrderDaoImpl();
	private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
	private BookDaoImpl bookDaoImpl = new BookDaoImpl();
	@Override
	public String createOrder(Cart cast, Integer userId) {
		String orderId=System.currentTimeMillis()+""+userId;
		orderDao.saveOrder(new Order(userId, orderId, cast.getTotalPrice(), 0, new Date()));
		OrderItem orderItem = new OrderItem();
		for (CartItem calrtlem : cast.getItems().values()) {
			orderItem.setName(calrtlem.getName());
			orderItem.setOrderId(orderId);
			orderItem.setCount(calrtlem.getCount());
			orderItem.setPrice(calrtlem.getPrice());
			orderItem.setTotalPrice(calrtlem.getPriceTotal());
			orderItemDao.saveOrderItem(orderItem);
			
			Book book = bookDaoImpl.queryBookById(calrtlem.getId());
			book.setSales(book.getSales()+calrtlem.getCount());
			book.setStock(book.getStock()-calrtlem.getCount());
			bookDaoImpl.updateBook(book);
		}
		
		return orderId;
	}

}
