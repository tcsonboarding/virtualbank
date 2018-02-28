package com.virtualbank.billpay.domain;

import com.virtualbank.billpay.utils.ExternalizedEnums;

public class CreditScore {
	
	private Long id;

	private String ssn;
	private ExternalizedEnums.EventType eventType;
	private Integer scoreChange;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public ExternalizedEnums.EventType getEventType() {
		return eventType;
	}
	public void setEventType(ExternalizedEnums.EventType eventType) {
		this.eventType = eventType;
	}
	public Integer getScoreChange() {
		return scoreChange;
	}
	public void setScoreChange(Integer scoreChange) {
		this.scoreChange = scoreChange;
	}

}
