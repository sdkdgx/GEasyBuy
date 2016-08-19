package sdust.easybuy.model;

/**
 * EasyBuyOrderDetail entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyOrderDetail implements java.io.Serializable {

	// Fields

	private Integer eodId;
	private EasyBuyProduct easyBuyProduct;
	private EasyBuyOrder easyBuyOrder;
	private Integer eodQuantity;

	// Constructors

	/** default constructor */
	public EasyBuyOrderDetail() {
	}

	/** full constructor */
	public EasyBuyOrderDetail(EasyBuyProduct easyBuyProduct,
			EasyBuyOrder easyBuyOrder, Integer eodQuantity) {
		this.easyBuyProduct = easyBuyProduct;
		this.easyBuyOrder = easyBuyOrder;
		this.eodQuantity = eodQuantity;
	}

	// Property accessors

	public Integer getEodId() {
		return this.eodId;
	}

	public void setEodId(Integer eodId) {
		this.eodId = eodId;
	}

	public EasyBuyProduct getEasyBuyProduct() {
		return this.easyBuyProduct;
	}

	public void setEasyBuyProduct(EasyBuyProduct easyBuyProduct) {
		this.easyBuyProduct = easyBuyProduct;
	}

	public EasyBuyOrder getEasyBuyOrder() {
		return this.easyBuyOrder;
	}

	public void setEasyBuyOrder(EasyBuyOrder easyBuyOrder) {
		this.easyBuyOrder = easyBuyOrder;
	}

	public Integer getEodQuantity() {
		return this.eodQuantity;
	}

	public void setEodQuantity(Integer eodQuantity) {
		this.eodQuantity = eodQuantity;
	}

}