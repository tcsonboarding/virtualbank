package com.digid.bfsi.trainings.virtualbank.creditScore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.digid.bfsi.trainings.virtualbank.creditScore.domain.ExternalizedEnums.EventType;

@Entity
public class CreditEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4150428252794113718L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String ssn;
	private EventType eventType;
	private long scoreChange;

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public long getScoreChange() {
		return scoreChange;
	}

	public void setScoreChange(long scoreChange) {
		this.scoreChange = scoreChange;
	}

	@Override
	public String toString() {
		return "CreditEvent [eventType=" + eventType + ", scoreChange=" + scoreChange + "]";
	}

}
