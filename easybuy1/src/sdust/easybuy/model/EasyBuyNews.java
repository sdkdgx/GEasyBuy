package sdust.easybuy.model;

import java.util.Date;

/**
 * EasybuyNews entity. @author MyEclipse Persistence Tools
 */

public class EasyBuyNews {

	// Fields

	private Integer enId;
	private String enTitle;
	private String enContent;
	private Date enCreateTime;

	// Constructors

	/** default constructor */
	public EasyBuyNews() {
	}

	/** full constructor */
	public EasyBuyNews(String enTitle, String enContent, Date enCreateTime) {
		this.enTitle = enTitle;
		this.enContent = enContent;
		this.enCreateTime = enCreateTime;
	}

	// Property accessors

	public Integer getEnId() {
		return this.enId;
	}

	public void setEnId(Integer enId) {
		this.enId = enId;
	}

	public String getEnTitle() {
		return this.enTitle;
	}

	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}

	public String getEnContent() {
		return this.enContent;
	}

	public void setEnContent(String enContent) {
		this.enContent = enContent;
	}

	public Date getEnCreateTime() {
		return this.enCreateTime;
	}

	public void setEnCreateTime(Date enCreateTime) {
		this.enCreateTime = enCreateTime;
	}

}