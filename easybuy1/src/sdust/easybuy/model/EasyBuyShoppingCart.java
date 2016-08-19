package sdust.easybuy.model;

/**
 * EasyBuyShoppingCart entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyShoppingCart implements java.io.Serializable {

	// Fields

	private Integer escId;
	private EasyBuyProduct easyBuyProduct;
	private EasyBuyUser easyBuyUser;
	private Integer escProductQuantity;

	// Constructors

	/** default constructor */
	public EasyBuyShoppingCart() {
	}

	/** full constructor */
	public EasyBuyShoppingCart(EasyBuyProduct easyBuyProduct,
			EasyBuyUser easyBuyUser, Integer escProductQuantity) {
		this.easyBuyProduct = easyBuyProduct;
		this.easyBuyUser = easyBuyUser;
		this.escProductQuantity = escProductQuantity;
	}

	// Property accessors

	public Integer getEscId() {
		return this.escId;
	}

	public void setEscId(Integer escId) {
		this.escId = escId;
	}

	public EasyBuyProduct getEasyBuyProduct() {
		return this.easyBuyProduct;
	}

	public void setEasyBuyProduct(EasyBuyProduct easyBuyProduct) {
		this.easyBuyProduct = easyBuyProduct;
	}

	public EasyBuyUser getEasyBuyUser() {
		return this.easyBuyUser;
	}

	public void setEasyBuyUser(EasyBuyUser easyBuyUser) {
		this.easyBuyUser = easyBuyUser;
	}

	public Integer getEscProductQuantity() {
		return this.escProductQuantity;
	}

	public void setEscProductQuantity(Integer escProductQuantity) {
		this.escProductQuantity = escProductQuantity;
	}

}