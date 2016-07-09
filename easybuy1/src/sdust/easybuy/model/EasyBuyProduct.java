package sdust.easybuy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * EasybuyProduct entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyProduct {

	// Fields

	private Integer epId;
	private EasyBuyProductCategory easybuyProductCategory;
	private String epName;
	private String epDescription;
	private Double epPrice;
	private Integer epStock;
	private Integer epcChildId;
	private String epFileName;
	private Set easybuyOrderDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public EasyBuyProduct() {
	}

	/** minimal constructor */
	public EasyBuyProduct(EasyBuyProductCategory easybuyProductCategory,
			String epName, String epDescription, Double epPrice,
			Integer epStock, Integer epcChildId, String epFileName) {
		this.easybuyProductCategory = easybuyProductCategory;
		this.epName = epName;
		this.epDescription = epDescription;
		this.epPrice = epPrice;
		this.epStock = epStock;
		this.epcChildId = epcChildId;
		this.epFileName = epFileName;
	}

	/** full constructor */
	public EasyBuyProduct(EasyBuyProductCategory easybuyProductCategory,
			String epName, String epDescription, Double epPrice,
			Integer epStock, Integer epcChildId, String epFileName,
			Set easybuyOrderDetails) {
		this.easybuyProductCategory = easybuyProductCategory;
		this.epName = epName;
		this.epDescription = epDescription;
		this.epPrice = epPrice;
		this.epStock = epStock;
		this.epcChildId = epcChildId;
		this.epFileName = epFileName;
		this.easybuyOrderDetails = easybuyOrderDetails;
	}

	// Property accessors

	public Integer getEpId() {
		return this.epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	public EasyBuyProductCategory getEasybuyProductCategory() {
		return this.easybuyProductCategory;
	}

	public void setEasybuyProductCategory(
			EasyBuyProductCategory easybuyProductCategory) {
		this.easybuyProductCategory = easybuyProductCategory;
	}

	public String getEpName() {
		return this.epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public String getEpDescription() {
		return this.epDescription;
	}

	public void setEpDescription(String epDescription) {
		this.epDescription = epDescription;
	}

	public Double getEpPrice() {
		return this.epPrice;
	}

	public void setEpPrice(Double epPrice) {
		this.epPrice = epPrice;
	}

	public Integer getEpStock() {
		return this.epStock;
	}

	public void setEpStock(Integer epStock) {
		this.epStock = epStock;
	}

	public Integer getEpcChildId() {
		return this.epcChildId;
	}

	public void setEpcChildId(Integer epcChildId) {
		this.epcChildId = epcChildId;
	}

	public String getEpFileName() {
		return this.epFileName;
	}

	public void setEpFileName(String epFileName) {
		this.epFileName = epFileName;
	}

	public Set getEasybuyOrderDetails() {
		return this.easybuyOrderDetails;
	}

	public void setEasybuyOrderDetails(Set easybuyOrderDetails) {
		this.easybuyOrderDetails = easybuyOrderDetails;
	}

	@Override
	public String toString() {
		return "EasyBuyProduct [epId=" + epId + ", easybuyProductCategory="
				+ easybuyProductCategory + ", epName=" + epName
				+ ", epDescription=" + epDescription + ", epPrice=" + epPrice
				+ ", epStock=" + epStock + ", epcChildId=" + epcChildId
				+ ", epFileName=" + epFileName + ", easybuyOrderDetails="
				+ easybuyOrderDetails + "]";
	}
	
	

}