package sdust.easybuy.model;

import java.sql.Timestamp;

public class EasyBuyComment implements java.io.Serializable {

	private Integer ecId;
	private EasyBuyUser easyBuyUser;
	private String ecReply;
	private String ecContent;
	private Timestamp ecCreateTime;
	private Timestamp ecReplyTime;

	public EasyBuyComment() {
	}

	public EasyBuyComment(String ecContent, Timestamp ecCreateTime) {
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
	}

	public EasyBuyComment(EasyBuyUser easyBuyUser, String ecReply,
			String ecContent, Timestamp ecCreateTime, Timestamp ecReplyTime) {
		this.easyBuyUser = easyBuyUser;
		this.ecReply = ecReply;
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
		this.ecReplyTime = ecReplyTime;
	}

	public Integer getEcId() {
		return this.ecId;
	}

	public void setEcId(Integer ecId) {
		this.ecId = ecId;
	}

	public EasyBuyUser getEasyBuyUser() {
		return this.easyBuyUser;
	}

	public void setEasyBuyUser(EasyBuyUser easyBuyUser) {
		this.easyBuyUser = easyBuyUser;
	}

	public String getEcReply() {
		return this.ecReply;
	}

	public void setEcReply(String ecReply) {
		this.ecReply = ecReply;
	}

	public String getEcContent() {
		return this.ecContent;
	}

	public void setEcContent(String ecContent) {
		this.ecContent = ecContent;
	}

	public Timestamp getEcCreateTime() {
		return this.ecCreateTime;
	}

	public void setEcCreateTime(Timestamp ecCreateTime) {
		this.ecCreateTime = ecCreateTime;
	}

	public Timestamp getEcReplyTime() {
		return this.ecReplyTime;
	}

	public void setEcReplyTime(Timestamp ecReplyTime) {
		this.ecReplyTime = ecReplyTime;
	}

}