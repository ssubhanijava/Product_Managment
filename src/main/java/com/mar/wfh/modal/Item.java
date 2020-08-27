package com.mar.wfh.modal;

public class Item {

	private product product;
	private int quantity;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
