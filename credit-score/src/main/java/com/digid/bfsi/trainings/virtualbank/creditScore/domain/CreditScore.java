package com.digid.bfsi.trainings.virtualbank.creditScore.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CreditScore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7727495741226508258L;

	@Id
	@Column(name = "ssn", nullable = false)
	private String ssn;

	@OneToMany(mappedBy = "creditScore", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CreditEvent> creditEventList;

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public long getScore() {
		long score = 0;

		for (CreditEvent event : creditEventList) {
			score += event.getScoreChange();
		}
		return score;
	}

	@Override
	public String toString() {
		return "CreditScore [ssn=" + ssn + ", score=" + getScore() + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addCreditEvent(CreditEvent event) {

	}

}
