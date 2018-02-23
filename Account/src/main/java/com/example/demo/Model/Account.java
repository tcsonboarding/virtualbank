package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.example.demo.Model.ExternalizedEnums.AccountType;

@Entity
public class Account {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany
    @JoinColumn(name = "customerId")
	
	private String accountId;
	
	private ExternalizedEnums.AccountType accountType;
	
	private String openingBallance = "25";
	
	private String monthlyFee = "5";
	
	private String minimumBalance = "25";
	
	private String overDruftLimit = "200";
	
	public Account() {
	
	}
	

	public Account(Long id, String accountId, AccountType accountType, String openingBallance, String monthlyFee,
			String minimumBalance, String overDruftLimit) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.accountType = accountType;
		this.openingBallance = openingBallance;
		this.monthlyFee = monthlyFee;
		this.minimumBalance = minimumBalance;
		this.overDruftLimit = overDruftLimit;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return accountId;
	}

	public void setCustomerId(String accountId) {
		this.accountId = accountId;
	}

	public ExternalizedEnums.AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(ExternalizedEnums.AccountType accountType) {
		this.accountType = accountType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOpeningBallance() {
		return openingBallance;
	}

	public void setOpeningBallance(String openingBallance) {
		this.openingBallance = openingBallance;
	}

	public String getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(String monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public String getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(String minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getOverDruftLimit() {
		return overDruftLimit;
	}

	public void setOverDruftLimit(String overDruftLimit) {
		this.overDruftLimit = overDruftLimit;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountId=" + accountId + ", accountType=" + accountType
				+ ", openingBallance=" + openingBallance + ", monthlyFee=" + monthlyFee + ", minimumBalance="
				+ minimumBalance + ", overDruftLimit=" + overDruftLimit + "]";
	}

	


}
