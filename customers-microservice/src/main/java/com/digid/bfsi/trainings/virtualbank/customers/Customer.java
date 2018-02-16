package com.digid.bfsi.trainings.virtualbank.customers;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.digid.bfsi.trainings.virtualbank.customers.utils.LocalDateDeserializer;
import com.digid.bfsi.trainings.virtualbank.customers.utils.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private ExternalizedEnums.CustomerType custType;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custType=" + custType + ", dateOfBirth=" + dateOfBirth + ", ssn=" + ssn
				+ ", idType=" + idType + ", idNumber=" + idNumber + ", streetAddress=" + streetAddress + ", state="
				+ state + ", zipCode=" + zipCode + "]";
	}

}