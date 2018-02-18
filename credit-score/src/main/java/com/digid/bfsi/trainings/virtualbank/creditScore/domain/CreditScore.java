package com.digid.bfsi.trainings.virtualbank.creditScore.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditScore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7727495741226508258L;

	@Id
	@Column(name = "ssn", nullable = false)
	private String ssn;
	private long score;

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "CreditScore [ssn=" + ssn + ", score=" + score + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
