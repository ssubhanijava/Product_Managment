package com.mar.wfh.modal;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 20)
	private int orderItemId;

	@Column(length = 20)
	private int orderId;

	@Column(length = 60)
	private String productName;

	@Column(length = 20)
	private int vendorProductId;

	@Column(length = 20)
	private int quantity;

	@Column(length = 20)
	private double priceEach;

	@Column(length = 20)
	private double priceTotal;

	@Column(length = 20)
	private int productId;

	@Column(length = 10)
	private boolean status;

	@Column(length = 20)
	private LocalDate approveDate;

	private int userId;

	@Column(length = 20)
	private Date reject_date;

	@Column(length = 20)
	private Date dispatch_date;
	@Column(length = 20)
	private Date delivary_date;
	@Column(length = 60)
	private String reason;

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getVendorProductId() {
		return vendorProductId;
	}

	public void setVendorProductId(int vendorProductId) {
		this.vendorProductId = vendorProductId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(LocalDate approveDate) {
		this.approveDate = approveDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getReject_date() {
		return reject_date;
	}

	public void setReject_date(Date reject_date) {
		this.reject_date = reject_date;
	}

	public Date getDispatch_date() {
		return dispatch_date;
	}

	public void setDispatch_date(Date dispatch_date) {
		this.dispatch_date = dispatch_date;
	}

	public Date getDelivary_date() {
		return delivary_date;
	}

	public void setDelivary_date(Date delivary_date) {
		this.delivary_date = delivary_date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Order [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productName=" + productName
				+ ", vendorProductId=" + vendorProductId + ", quantity=" + quantity + ", priceEach=" + priceEach
				+ ", priceTotal=" + priceTotal + ", productId=" + productId + ", status=" + status + ", approveDate="
				+ approveDate + ", userId=" + userId + ", reject_date=" + reject_date + ", dispatch_date="
				+ dispatch_date + ", delivary_date=" + delivary_date + ", reason=" + reason + "]";
	}

}
