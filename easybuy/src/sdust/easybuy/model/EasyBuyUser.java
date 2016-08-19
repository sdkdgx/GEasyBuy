package sdust.easybuy.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class EasyBuyUser implements java.io.Serializable {

	private Integer euUserId;
	private String euUserName;
	private String euPassword;
	private Integer euSex;
	private Date euBirthday;
	private String euIdentityCode;
	private String euEmail;
	private String euMobile;
	private String euAddress;
	private Integer euStatus;
	private Set easyBuyComments = new HashSet(0);
	private Set easyBuyOrders = new HashSet(0);
	private Set easyBuyShoppingCarts = new HashSet(0);

	public EasyBuyUser() {
	}

	public EasyBuyUser(String euUserName, String euPassword, Integer euStatus) {
		this.euUserName = euUserName;
		this.euPassword = euPassword;
		this.euStatus = euStatus;
	}

	public EasyBuyUser(String euUserName, String euPassword, Integer euSex,
			Date euBirthday, String euIdentityCode, String euEmail,
			String euMobile, String euAddress, Integer euStatus,
			Set easyBuyComments, Set easyBuyOrders, Set easyBuyShoppingCarts) {
		this.euUserName = euUserName;
		this.euPassword = euPassword;
		this.euSex = euSex;
		this.euBirthday = euBirthday;
		this.euIdentityCode = euIdentityCode;
		this.euEmail = euEmail;
		this.euMobile = euMobile;
		this.euAddress = euAddress;
		this.euStatus = euStatus;
		this.easyBuyComments = easyBuyComments;
		this.easyBuyOrders = easyBuyOrders;
		this.easyBuyShoppingCarts = easyBuyShoppingCarts;
	}

	public Integer getEuUserId() {
		return this.euUserId;
	}

	public void setEuUserId(Integer euUserId) {
		this.euUserId = euUserId;
	}

	public String getEuUserName() {
		return this.euUserName;
	}

	public void setEuUserName(String euUserName) {
		this.euUserName = euUserName;
	}

	public String getEuPassword() {
		return this.euPassword;
	}

	public void setEuPassword(String euPassword) {
		this.euPassword = euPassword;
	}

	public Integer getEuSex() {
		return this.euSex;
	}

	public void setEuSex(Integer euSex) {
		this.euSex = euSex;
	}

	public Date getEuBirthday() {
		return this.euBirthday;
	}

	public void setEuBirthday(Date euBirthday) {
		this.euBirthday = euBirthday;
	}

	public String getEuIdentityCode() {
		return this.euIdentityCode;
	}

	public void setEuIdentityCode(String euIdentityCode) {
		this.euIdentityCode = euIdentityCode;
	}

	public String getEuEmail() {
		return this.euEmail;
	}

	public void setEuEmail(String euEmail) {
		this.euEmail = euEmail;
	}

	public String getEuMobile() {
		return this.euMobile;
	}

	public void setEuMobile(String euMobile) {
		this.euMobile = euMobile;
	}

	public String getEuAddress() {
		return this.euAddress;
	}

	public void setEuAddress(String euAddress) {
		this.euAddress = euAddress;
	}

	public Integer getEuStatus() {
		return this.euStatus;
	}

	public void setEuStatus(Integer euStatus) {
		this.euStatus = euStatus;
	}

	public Set getEasyBuyComments() {
		return this.easyBuyComments;
	}

	public void setEasyBuyComments(Set easyBuyComments) {
		this.easyBuyComments = easyBuyComments;
	}

	public Set getEasyBuyOrders() {
		return this.easyBuyOrders;
	}

	public void setEasyBuyOrders(Set easyBuyOrders) {
		this.easyBuyOrders = easyBuyOrders;
	}

	public Set getEasyBuyShoppingCarts() {
		return this.easyBuyShoppingCarts;
	}

	public void setEasyBuyShoppingCarts(Set easyBuyShoppingCarts) {
		this.easyBuyShoppingCarts = easyBuyShoppingCarts;
	}

	public EasyBuyUser(String euUserName, String euPassword) {
		super();
		this.euUserName = euUserName;
		this.euPassword = euPassword;
	}

}