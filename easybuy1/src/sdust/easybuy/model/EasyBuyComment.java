package sdust.easybuy.model;

import java.sql.Timestamp;

/**
 * EasybuyComment entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyComment{

	// Fields

	private Integer ecId;
	private EasyBuyUser easybuyUser;
	private String ecReply;
	private String ecContent;
	private Timestamp ecCreateTime;
	private Timestamp ecReplyTime;

	// Constructors

	/** default constructor */
	public EasyBuyComment() {
	}

	/** minimal constructor */
	public EasyBuyComment(String ecReply, String ecContent,
			Timestamp ecCreateTime, Timestamp ecReplyTime) {
		this.ecReply = ecReply;
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
		this.ecReplyTime = ecReplyTime;
	}

	/** full constructor */
	public EasyBuyComment(EasyBuyUser easybuyUser, String ecReply,
			String ecContent, Timestamp ecCreateTime, Timestamp ecReplyTime) {
		this.easybuyUser = easybuyUser;
		this.ecReply = ecReply;
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
		this.ecReplyTime = ecReplyTime;
	}

	// Property accessors

	public Integer getEcId() {
		return this.ecId;
	}

	public void setEcId(Integer ecId) {
		this.ecId = ecId;
	}

	public EasyBuyUser getEasybuyUser() {
		return this.easybuyUser;
	}

	public void setEasybuyUser(EasyBuyUser easybuyUser) {
		this.easybuyUser = easybuyUser;
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