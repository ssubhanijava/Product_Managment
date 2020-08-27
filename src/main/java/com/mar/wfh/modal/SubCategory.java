package com.mar.wfh.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prod_SubCategory")
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SubCat_Id", length = 20)
	private long sid;
	@Column(name = "SubCat_Name", length = 50)
	private String sName;
	@Column(name = "SubCat_Desc", length = 50)
	private String sDescription;
	@Column(name = "ProuctCategory", length = 50)
	private String productCategory;

	public long getSid() {
		return sid;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsDescription() {
		return sDescription;
	}

	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}

	@Override
	public String toString() {
		return "SubCategory [sid=" + sid + ", sName=" + sName + ", sDescription=" + sDescription + ", productCategory="
				+ productCategory + "]";
	}

}
