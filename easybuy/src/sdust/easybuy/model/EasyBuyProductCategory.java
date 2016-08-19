package sdust.easybuy.model;

import java.util.HashSet;
import java.util.Set;

public class EasyBuyProductCategory implements java.io.Serializable {

	private Integer epcId;
	private String epcName;
	private Integer epcParentId;
	private Set easyBuyProducts = new HashSet(0);

	public EasyBuyProductCategory() {
	}

	public EasyBuyProductCategory(String epcName) {
		this.epcName = epcName;
	}

	public EasyBuyProductCategory(String epcName, Integer epcParentId,
			Set easyBuyProducts) {
		this.epcName = epcName;
		this.epcParentId = epcParentId;
		this.easyBuyProducts = easyBuyProducts;
	}

	public Integer getEpcId() {
		return this.epcId;
	}

	public void setEpcId(Integer epcId) {
		this.epcId = epcId;
	}

	public String getEpcName() {
		return this.epcName;
	}

	public void setEpcName(String epcName) {
		this.epcName = epcName;
	}

	public Integer getEpcParentId() {
		return this.epcParentId;
	}

	public void setEpcParentId(Integer epcParentId) {
		this.epcParentId = epcParentId;
	}

	public Set getEasyBuyProducts() {
		return this.easyBuyProducts;
	}

	public void setEasyBuyProducts(Set easyBuyProducts) {
		this.easyBuyProducts = easyBuyProducts;
	}

}