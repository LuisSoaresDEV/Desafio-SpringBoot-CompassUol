package com.devtocode.ecommerce.entities.enums;

public enum OrderStatus {
	
	
	WAITING_PAYMENTS(0),
	PAID(1),
	SHIPED(2),
	DELIVERED(3),
	CACELLED(4);
	
	
	private int code;
	
	
	private OrderStatus(int code) {
		this.code = code;
		
	}
	
	
	public int getCode() {
		return code;
	}
	
	
	public static OrderStatus valueOf(int code) {
		
		for(OrderStatus value: OrderStatus.values()) {
			
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalAccessError("Invalid code");
	}

}
