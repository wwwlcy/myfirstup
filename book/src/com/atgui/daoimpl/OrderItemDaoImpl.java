package com.atgui.daoimpl;

import com.atgui.dao.OrderItemDao;
import com.atgui.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao {

	@Override
	public int saveOrderItem(OrderItem orderItem) {
		String sql="INSERT INTO `book`.`t_order_item`(`id`,`name`, `price`, `total_money`,`count`,`order_id`)"
				+ "VALUES (?, ?,?,?, ?, ?);";
		//INSERT INTO `book`.`t_order_item`(`id`,`name`, `price`, `priacetotal`,`count`,`order_id`)
		//VALUES ('id', 'name','price','priacetotal', 'count' 'order_id');
		return update(sql, orderItem.getId(),orderItem.getName(),orderItem.getPrice(),orderItem.getTotalPrice(),
				orderItem.getCount(),orderItem.getOrderId());
	}

}
