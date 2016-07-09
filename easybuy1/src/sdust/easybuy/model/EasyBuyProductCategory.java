package sdust.easybuy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * EasybuyProductCategory entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyProductCategory {

	// Fields

	private Integer epcId;
	private String epcName;
	private Integer epcParentId;
	private Set easybuyProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public EasyBuyProductCategory() {
	}

	/** minimal constructor */
	public EasyBuyProductCategory(String epcName) {
		this.epcName = epcName;
	}

	/** full constructor */
	public EasyBuyProductCategory(String epcName, Integer epcParentId,
			Set easybuyProducts) {
		this.epcName = epcName;
		this.epcParentId = epcParentId;
		this.easybuyProducts = easybuyProducts;
	}

	// Property accessors

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

	public Set getEasybuyProducts() {
		return this.easybuyProducts;
	}

	public void setEasybuyProducts(Set easybuyProducts) {
		this.easybuyProducts = easybuyProducts;
	}

}