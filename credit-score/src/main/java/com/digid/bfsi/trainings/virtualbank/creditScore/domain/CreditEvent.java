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

	/*
	 * Is using a constructor for all member fields safe in a Spring Boot /
	 * Hibernate build?
	 */
	public CreditEvent(Long id, String ssn, EventType eventType, int scoreChange) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.eventType = eventType;
		this.scoreChange = scoreChange;
	}

	public CreditEvent() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String ssn;
	private EventType eventType;
	private Integer scoreChange;

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

	public int getScoreChange() {
		return scoreChange;
	}

	public void setScoreChange(int scoreChange) {
		this.scoreChange = scoreChange;
	}

	@Override
	public String toString() {
		return "CreditEvent [eventType=" + eventType + ", scoreChange=" + scoreChange + "]";
	}

}
