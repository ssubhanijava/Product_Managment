package com.mar.wfh.modal;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Customer_Tbl")
//@DynamicUpdate(true)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Customer_ID", length = 20)
	private Integer cid;
	@Column(name = "Customer_Name", length = 50)
	@Length(min = 5, message = "*Your Customer name must have at least 5 characters")
	@NotEmpty(message = "*Please provide a Customer name")
	private String cName;
	@Column(name = "Customer_Email", length = 60)
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String cEmail;
	@Column(name = "Customer_PassWord", length = 64)
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String cPassWord;
	@Column(name = "Customer_Phone", length = 20)
	private String cPhone;
	@Column(name = "Customer_Status", length = 15)
	private boolean cStatus;
	@Column(name = "Customer_Date", length = 20)
	private Date CEnquiryDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_role", joinColumns = { @JoinColumn(name = "Customer_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Role roles;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Address> address;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcPassWord() {
		return cPassWord;
	}

	public void setcPassWord(String cPassWord) {
		this.cPassWord = cPassWord;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public boolean iscStatus() {
		return cStatus;
	}

	public void setcStatus(boolean cStatus) {
		this.cStatus = cStatus;
	}

	public Date getCEnquiryDate() {
		return CEnquiryDate;
	}

	public void setCEnquiryDate(Date cEnquiryDate) {
		CEnquiryDate = cEnquiryDate;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cName=" + cName + ", cEmail=" + cEmail + ", cPassWord=" + cPassWord
				+ ", cPhone=" + cPhone + ", cStatus=" + cStatus + ", CEnquiryDate=" + CEnquiryDate + ", roles=" + roles
				+ ", address=" + address + "]";
	}

}
