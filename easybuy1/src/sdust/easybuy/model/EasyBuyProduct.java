package sdust.easybuy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * EasyBuyProduct entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyProduct implements java.io.Serializable {

	// Fields

	private Integer epId;
	private EasyBuyProductCategory easyBuyProductCategory;
	private String epName;
	private String epDescription;
	private Double epPrice;
	private Integer epStock;
	private Integer epcChildId;
	private String epFileName;
	private Integer epSpecial;
	private Set easyBuyOrderDetails = new HashSet(0);
	private Set easyBuyShoppingCarts = new HashSet(0);

	// Constructors

	/** default constructor */
	public EasyBuyProduct() {
	}

	/** minimal constructor */
	public EasyBuyProduct(EasyBuyProductCategory easyBuyProductCategory,
			String epName, String epDescription, Double epPrice,
			Integer epStock, Integer epcChildId, String epFileName,
			Integer epSpecial) {
		this.easyBuyProductCategory = easyBuyProductCategory;
		this.epName = epName;
		this.epDescription = epDescription;
		this.epPrice = epPrice;
		this.epStock = epStock;
		this.epcChildId = epcChildId;
		this.epFileName = epFileName;
		this.epSpecial = epSpecial;
	}

	/** full constructor */
	public EasyBuyProduct(EasyBuyProductCategory easyBuyProductCategory,
			String epName, String epDescription, Double epPrice,
			Integer epStock, Integer epcChildId, String epFileName,
			Integer epSpecial, Set easyBuyOrderDetails, Set easyBuyShoppingCarts) {
		this.easyBuyProductCategory = easyBuyProductCategory;
		this.epName = epName;
		this.epDescription = epDescription;
		this.epPrice = epPrice;
		this.epStock = epStock;
		this.epcChildId = epcChildId;
		this.epFileName = epFileName;
		this.epSpecial = epSpecial;
		this.easyBuyOrderDetails = easyBuyOrderDetails;
		this.easyBuyShoppingCarts = easyBuyShoppingCarts;
	}

	// Property accessors

	public Integer getEpId() {
		return this.epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	public EasyBuyProductCategory getEasyBuyProductCategory() {
		return this.easyBuyProductCategory;
	}

	public void setEasyBuyProductCategory(
			EasyBuyProductCategory easyBuyProductCategory) {
		this.easyBuyProductCategory = easyBuyProductCategory;
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

	public Integer getEpSpecial() {
		return this.epSpecial;
	}

	public void setEpSpecial(Integer epSpecial) {
		this.epSpecial = epSpecial;
	}

	public Set getEasyBuyOrderDetails() {
		return this.easyBuyOrderDetails;
	}

	public void setEasyBuyOrderDetails(Set easyBuyOrderDetails) {
		this.easyBuyOrderDetails = easyBuyOrderDetails;
	}

	public Set getEasyBuyShoppingCarts() {
		return this.easyBuyShoppingCarts;
	}

	public void setEasyBuyShoppingCarts(Set easyBuyShoppingCarts) {
		this.easyBuyShoppingCarts = easyBuyShoppingCarts;
	}

}