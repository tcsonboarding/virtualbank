package com.digid.bfsi.trainings.virtualbank.creditScore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.digid.bfsi.trainings.virtualbank.creditScore.domain.ExternalizedEnums.EventType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CreditEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4150428252794113718L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ssn")
	@JsonIgnore
	private CreditScore creditScore;


	private EventType eventType;
	private long scoreChange;

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
