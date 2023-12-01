package com.example.webbanhang.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class BillItemsKey implements Serializable {
	private Long productId;
	private Long billId;
	public BillItemsKey(Long productId, Long billId) {
		
		this.productId = productId;
		this.billId = billId;
	}
	
	
	
	
}
