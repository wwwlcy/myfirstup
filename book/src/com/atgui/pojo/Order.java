package com.atgui.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	private Integer uesrId;
	private String orderId;
	private BigDecimal price;
	private Integer status=0;  //商品状态，0未发货，1是已发货，2是以签收
	private Date  creatTime;

	public Order(Integer uesrId, String orderId, BigDecimal price, Integer status, Date creatTime) {
		super();
		this.uesrId = uesrId;
		this.orderId = orderId;
		this.price = price;
		this.status = status;
		this.creatTime = creatTime;
	}
	
	public Order() {
		super();
	}
	public Integer getUesrId() {
		return uesrId;
	}
	public void setUesrId(Integer uesrId) {
		this.uesrId = uesrId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	@Override
	public String toString() {
		return "Order [uesrId=" + uesrId + ", orderId=" + orderId + ", price=" + price + ", status=" + status
				+ ", creatTime=" + creatTime + "]";
	}
	
}
