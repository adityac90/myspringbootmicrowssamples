package com.example.demo.springboot.models;

public class Transaction {

	int orderId;
	int itemId;
	int orderQty;
	String region;

	public Transaction() {

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Transaction [orderId=" + orderId + ", itemId=" + itemId + ", orderQty=" + orderQty + ", region="
				+ region + "]";
	}

	
	
}
