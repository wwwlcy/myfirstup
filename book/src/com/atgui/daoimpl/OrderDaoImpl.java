package com.atgui.daoimpl;

import com.atgui.dao.OrderDao;
import com.atgui.pojo.Order;

public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		String sql="INSERT INTO `book`.`t_order`(`order_id`,`create_time`,`total_money`,`status`, `user_id`)"
				+ "VALUES (?,?,?,?,?);";
		//INSERT INTO `book`.`t_order`(`order_id`,`create_time`,`price`,`status`, `user_id`)
		//VALUES ('order_id','create_time','price','status','user_id');
		return update(sql, order.getOrderId(),order.getCreatTime(),order.getPrice(),order.getStatus(),order.getUesrId());
	}

}
