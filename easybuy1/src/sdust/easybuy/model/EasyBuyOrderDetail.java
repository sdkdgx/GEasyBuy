package sdust.easybuy.model;

/**
 * EasybuyOrderDetail entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyOrderDetail {

	// Fields

	private Integer eodId;
	private EasyBuyProduct easybuyProduct;
	private EasyBuyOrder easybuyOrder;
	private Integer eodQuantity;

	// Constructors

	/** default constructor */
	public EasyBuyOrderDetail() {
	}

	/** full constructor */
	public EasyBuyOrderDetail(EasyBuyProduct easybuyProduct,
			EasyBuyOrder easybuyOrder, Integer eodQuantity) {
		this.easybuyProduct = easybuyProduct;
		this.easybuyOrder = easybuyOrder;
		this.eodQuantity = eodQuantity;
	}

	// Property accessors

	public Integer getEodId() {
		return this.eodId;
	}

	public void setEodId(Integer eodId) {
		this.eodId = eodId;
	}

	public EasyBuyProduct getEasybuyProduct() {
		return this.easybuyProduct;
	}

	public void setEasybuyProduct(EasyBuyProduct easybuyProduct) {
		this.easybuyProduct = easybuyProduct;
	}

	public EasyBuyOrder getEasybuyOrder() {
		return this.easybuyOrder;
	}

	public void setEasybuyOrder(EasyBuyOrder easybuyOrder) {
		this.easybuyOrder = easybuyOrder;
	}

	public Integer getEodQuantity() {
		return this.eodQuantity;
	}

	public void setEodQuantity(Integer eodQuantity) {
		this.eodQuantity = eodQuantity;
	}

}