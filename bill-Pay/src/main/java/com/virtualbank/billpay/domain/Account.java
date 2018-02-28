package com.virtualbank.billpay.domain;

import com.virtualbank.billpay.utils.ExternalizedEnums;


public class Account {
	
	
	private Long accountId;
	
	
	private ExternalizedEnums.AccountType accountType;
	
	private String openingBallance;
	
	private String monthlyFee;
	
	private String minimumBalance;
	
	private String overDruftLimit;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public ExternalizedEnums.AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(ExternalizedEnums.AccountType accountType) {
		this.accountType = accountType;
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
	

}
