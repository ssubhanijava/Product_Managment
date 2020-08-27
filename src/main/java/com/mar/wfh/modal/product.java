package com.mar.wfh.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_tbl")
public class product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Product_id", length = 20)
	private Integer pid;

	@Column(name = "Product_Name", length = 50)
	private String pName;

	@Column(name = "Product_Category", length = 50)
	private String pCat;

	private String productImage;

	@Column(name = "Product_SkuCode", length = 50)
	private String skuCode;

	@Column(name = "Product_Price", length = 60)
	private float pPrice;

	@Column(name = "Product_Recipe", length = 50)
	private String recipe;

	@Column(name = "Product_CompanyName", length = 50)
	private String pCompanyName;

	@Column(name = "Product_SubCategory", length = 50)
	private String pSubCat;

	@Column(name = "Product_Specification", length = 50)
	private String pSpec;

	@Column(name = "Product_Weight", length = 50)
	private Integer pWeight;

	@Column(name = "Product_Type", length = 50)
	private String pType;
	
	@Column(name = "Product_Quentity", length = 50)
	private String quentity;
	
	

	public String getQuentity() {
		return quentity;
	}

	public void setQuentity(String quentity) {
		this.quentity = quentity;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCat() {
		return pCat;
	}

	public void setpCat(String pCat) {
		this.pCat = pCat;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public float getpPrice() {
		return pPrice;
	}

	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getpCompanyName() {
		return pCompanyName;
	}

	public void setpCompanyName(String pCompanyName) {
		this.pCompanyName = pCompanyName;
	}

	public String getpSubCat() {
		return pSubCat;
	}

	public void setpSubCat(String pSubCat) {
		this.pSubCat = pSubCat;
	}

	public String getpSpec() {
		return pSpec;
	}

	public void setpSpec(String pSpec) {
		this.pSpec = pSpec;
	}

	public Integer getpWeight() {
		return pWeight;
	}

	public void setpWeight(Integer pWeight) {
		this.pWeight = pWeight;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pCat == null) ? 0 : pCat.hashCode());
		result = prime * result + ((pCompanyName == null) ? 0 : pCompanyName.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + Float.floatToIntBits(pPrice);
		result = prime * result + ((pSpec == null) ? 0 : pSpec.hashCode());
		result = prime * result + ((pSubCat == null) ? 0 : pSubCat.hashCode());
		result = prime * result + ((pType == null) ? 0 : pType.hashCode());
		result = prime * result + ((pWeight == null) ? 0 : pWeight.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((productImage == null) ? 0 : productImage.hashCode());
		result = prime * result + ((quentity == null) ? 0 : quentity.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + ((skuCode == null) ? 0 : skuCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product other = (product) obj;
		if (pCat == null) {
			if (other.pCat != null)
				return false;
		} else if (!pCat.equals(other.pCat))
			return false;
		if (pCompanyName == null) {
			if (other.pCompanyName != null)
				return false;
		} else if (!pCompanyName.equals(other.pCompanyName))
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (Float.floatToIntBits(pPrice) != Float.floatToIntBits(other.pPrice))
			return false;
		if (pSpec == null) {
			if (other.pSpec != null)
				return false;
		} else if (!pSpec.equals(other.pSpec))
			return false;
		if (pSubCat == null) {
			if (other.pSubCat != null)
				return false;
		} else if (!pSubCat.equals(other.pSubCat))
			return false;
		if (pType == null) {
			if (other.pType != null)
				return false;
		} else if (!pType.equals(other.pType))
			return false;
		if (pWeight == null) {
			if (other.pWeight != null)
				return false;
		} else if (!pWeight.equals(other.pWeight))
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		if (productImage == null) {
			if (other.productImage != null)
				return false;
		} else if (!productImage.equals(other.productImage))
			return false;
		if (quentity == null) {
			if (other.quentity != null)
				return false;
		} else if (!quentity.equals(other.quentity))
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (skuCode == null) {
			if (other.skuCode != null)
				return false;
		} else if (!skuCode.equals(other.skuCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "product [pid=" + pid + ", pName=" + pName + ", pCat=" + pCat + ", productImage=" + productImage
				+ ", skuCode=" + skuCode + ", pPrice=" + pPrice + ", recipe=" + recipe + ", pCompanyName="
				+ pCompanyName + ", pSubCat=" + pSubCat + ", pSpec=" + pSpec + ", pWeight=" + pWeight + ", pType="
				+ pType + ", quentity=" + quentity + "]";
	}



}
