package com.atgui.test;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;
import com.atgui.daoimpl.OrderItemDaoImpl;
import com.atgui.pojo.OrderItem;

public class OrderItemDaoTest {

	@Test
	public void testSaveOrderItem() {
		int i = new OrderItemDaoImpl().saveOrderItem(new OrderItem(null, "aaa", 1, new BigDecimal(10), 
				new BigDecimal(10), "111111111"));
		System.out.println(i);
	}

}
