package com.example.webbanhang.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table
public class BillItems {
	@EmbeddedId
	private BillItemsKey billItemsKey;

	@ManyToOne
	@JoinColumn(name = "product_id")
	@MapsId("productId")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "bill_id")
	@MapsId("billId")
	private Bill bill;

	private int count;

	private float sum;

	public BillItemsKey getBillItemsKey() {
		return billItemsKey;
	}

	public void setBillItemsKey(BillItemsKey billItemsKey) {
		this.billItemsKey = billItemsKey;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
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
	
	public BillItems() {
		// TODO Auto-generated constructor stub
	}
}
