package com.shx.carros.entidades.enums;

public enum OrdemdeStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrdemdeStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrdemdeStatus valueOf(int code) {
		for (OrdemdeStatus value : OrdemdeStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("ordem invalida");
	}
}
