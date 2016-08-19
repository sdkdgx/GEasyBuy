package sdust.easybuy.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * EasyBuyOrder entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyOrder implements java.io.Serializable {

	// Fields

	private Integer eoId;
	private EasyBuyUser easyBuyUser;
	private Timestamp eoCreateTime;
	private Integer eoStatus;
	private Integer eoType;
	private String eoRerAddress;
	private Set easyBuyOrderDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public EasyBuyOrder() {
	}

	/** minimal constructor */
	public EasyBuyOrder(EasyBuyUser easyBuyUser, Timestamp eoCreateTime,
			Integer eoStatus, Integer eoType, String eoRerAddress) {
		this.easyBuyUser = easyBuyUser;
		this.eoCreateTime = eoCreateTime;
		this.eoStatus = eoStatus;
		this.eoType = eoType;
		this.eoRerAddress = eoRerAddress;
	}

	/** full constructor */
	public EasyBuyOrder(EasyBuyUser easyBuyUser, Timestamp eoCreateTime,
			Integer eoStatus, Integer eoType, String eoRerAddress,
			Set easyBuyOrderDetails) {
		this.easyBuyUser = easyBuyUser;
		this.eoCreateTime = eoCreateTime;
		this.eoStatus = eoStatus;
		this.eoType = eoType;
		this.eoRerAddress = eoRerAddress;
		this.easyBuyOrderDetails = easyBuyOrderDetails;
	}

	// Property accessors

	public Integer getEoId() {
		return this.eoId;
	}

	public void setEoId(Integer eoId) {
		this.eoId = eoId;
	}

	public EasyBuyUser getEasyBuyUser() {
		return this.easyBuyUser;
	}

	public void setEasyBuyUser(EasyBuyUser easyBuyUser) {
		this.easyBuyUser = easyBuyUser;
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

	public Set getEasyBuyOrderDetails() {
		return this.easyBuyOrderDetails;
	}

	public void setEasyBuyOrderDetails(Set easyBuyOrderDetails) {
		this.easyBuyOrderDetails = easyBuyOrderDetails;
	}

}