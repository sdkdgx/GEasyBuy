package sdust.easybuy.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * EasybuyOrder entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyOrder {

	// Fields

	private Integer eoId;
	private EasyBuyUser easybuyUser;
	private Timestamp eoCreateTime;
	private Integer eoStatus;
	private Integer eoType;
	private String eoRerAddress;
	private Set easybuyOrderDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public EasyBuyOrder() {
	}

	/** minimal constructor */
	public EasyBuyOrder(EasyBuyUser easybuyUser, Timestamp eoCreateTime,
			Integer eoStatus, Integer eoType, String eoRerAddress) {
		this.easybuyUser = easybuyUser;
		this.eoCreateTime = eoCreateTime;
		this.eoStatus = eoStatus;
		this.eoType = eoType;
		this.eoRerAddress = eoRerAddress;
	}

	/** full constructor */
	public EasyBuyOrder(EasyBuyUser easybuyUser, Timestamp eoCreateTime,
			Integer eoStatus, Integer eoType, String eoRerAddress,
			Set easybuyOrderDetails) {
		this.easybuyUser = easybuyUser;
		this.eoCreateTime = eoCreateTime;
		this.eoStatus = eoStatus;
		this.eoType = eoType;
		this.eoRerAddress = eoRerAddress;
		this.easybuyOrderDetails = easybuyOrderDetails;
	}

	// Property accessors

	public Integer getEoId() {
		return this.eoId;
	}

	public void setEoId(Integer eoId) {
		this.eoId = eoId;
	}

	public EasyBuyUser getEasybuyUser() {
		return this.easybuyUser;
	}

	public void setEasybuyUser(EasyBuyUser easybuyUser) {
		this.easybuyUser = easybuyUser;
	}

	public Timestamp getEoCreateTime() {
		return this.eoCreateTime;
	}

	public void setEoCreateTime(Timestamp eoCreateTime) {
		this.eoCreateTime = eoCreateTime;
	}

	public Integer getEoStatus() {
		return this.eoStatus;
	}

	public void setEoStatus(Integer eoStatus) {
		this.eoStatus = eoStatus;
	}

	public Integer getEoType() {
		return this.eoType;
	}

	public void setEoType(Integer eoType) {
		this.eoType = eoType;
	}

	public String getEoRerAddress() {
		return this.eoRerAddress;
	}

	public void setEoRerAddress(String eoRerAddress) {
		this.eoRerAddress = eoRerAddress;
	}

	public Set getEasybuyOrderDetails() {
		return this.easybuyOrderDetails;
	}

	public void setEasybuyOrderDetails(Set easybuyOrderDetails) {
		this.easybuyOrderDetails = easybuyOrderDetails;
	}

}