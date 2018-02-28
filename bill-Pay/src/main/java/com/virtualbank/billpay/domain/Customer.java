package com.virtualbank.billpay.domain;

import java.time.LocalDate;

import com.virtualbank.billpay.utils.ExternalizedEnums;

public class Customer {

	private Long id;

	private ExternalizedEnums.CustomerType custType;

	private LocalDate dateOfBirth;

	private String ssn;
	
	private ExternalizedEnums.IdType idType;

	private String idNumber;

	private String streetAddress;

	private ExternalizedEnums.StateSymbol state;

	private int zipCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExternalizedEnums.CustomerType getCustType() {
		return custType;
	}

	public void setCustType(ExternalizedEnums.CustomerType custType) {
		this.custType = custType;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public ExternalizedEnums.IdType getIdType() {
		return idType;
	}

	public void setIdType(ExternalizedEnums.IdType idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public ExternalizedEnums.StateSymbol getState() {
		return state;
	}

	public void setState(ExternalizedEnums.StateSymbol state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	
}
