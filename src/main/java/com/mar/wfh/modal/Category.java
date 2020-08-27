package com.mar.wfh.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prod_category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Cat_Id", length = 20)
	private long cid;
	@Column(name = "Cat_Name", length = 50)
	private String cName;
	@Column(name = "Cat_Desc", length = 50)
	private String cDescription;

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cName=" + cName + ", cDescription=" + cDescription + "]";
	}

}
