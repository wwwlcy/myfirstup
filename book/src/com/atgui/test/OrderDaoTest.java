package com.atgui.test;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.Test;
import com.atgui.daoimpl.OrderDaoImpl;
import com.atgui.pojo.Order;

public class OrderDaoTest {

	@Test
	public void testSaveOrder() {
		//OrderDao order=new OrderDaoImpl();
		int i = new OrderDaoImpl().saveOrder(new Order(1, "111111111", new BigDecimal(20), 0, new Date()));
		System.out.println(i);
	}

}
