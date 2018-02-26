package com.example.demo.Model.RequestModels;

import com.example.demo.Model.ExternalizedEnums;

public class AccountRequest {

	public AccountRequest() {
		// TODO Auto-generated constructor stub
	}
	private String customerId;

	private ExternalizedEnums.AccountType accountType;
	
	private String openingBallance;
	
	private String monthlyFee;
	
	private String minimumBalance;
	
	private String overDruftLimit;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
