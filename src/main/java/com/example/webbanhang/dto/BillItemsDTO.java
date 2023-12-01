package com.example.webbanhang.dto;

import com.example.webbanhang.entity.BillItemsKey;


public class BillItemsDTO {
	
	private BillItemsKey billItemsKey;

	
	private ProductDTO product;
	
	private BillDTO bill;

	private int count;

	private float sum;

	public BillItemsKey getBillItemsKey() {
		return billItemsKey;
	}

	public void setBillItemsKey(BillItemsKey billItemsKey) {
		this.billItemsKey = billItemsKey;
	}

	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public BillDTO getBill() {
		return bill;
	}

	public void setBill(BillDTO bill) {
		this.bill = bill;
	}
	
	
	
}
