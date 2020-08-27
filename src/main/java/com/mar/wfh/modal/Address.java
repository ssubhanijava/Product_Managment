package com.mar.wfh.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Address_id", length = 20)
	private Integer aId;
	@Column(name = "Customer_Address", length = 20)
	private String adresss;
	@Column(name = "Address_City", length = 20)
	private String city;
	@Column(name = "Address_District", length = 20)
	private String district;
	@Column(name = "Address_State", length = 20)
	private String State;
	@Column(name = "Address_Pincode", length = 20)
	private int pincode;

	@ManyToOne
	@JoinColumn(name = "Customer_ID")
	private Customer customer;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(Integer aId, String adresss, String city, String district, String state, int pincode,
			Customer customer) {
		super();
		this.aId = aId;
		this.adresss = adresss;
		this.city = city;
		this.district = district;
		State = state;
		this.pincode = pincode;
		this.customer = customer;
	}


	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getAdresss() {
		return adresss;
	}

	public void setAdresss(String adresss) {
		this.adresss = adresss;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [aId=" + aId + ", adresss=" + adresss + ", city=" + city + ", district=" + district + ", State="
				+ State + ", pincode=" + pincode + ", customer=" + customer + "]";
	}

}
