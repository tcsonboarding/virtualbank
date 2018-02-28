package com.virtualbank.billpay.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vendor implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @Column(name = "vendor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vendorId;

    public List<Bill> getBillPayList() {
        return billPayList;
    }

    public void setBillPayList(List<Bill> billPayList) {
        this.billPayList = billPayList;
    }

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Bill> billPayList;

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;
    private String billType;
    private float billAmount;

    public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public long getTotalBill() {
        long totalAmount = 0;
        for (Bill billPay : billPayList) {
            totalAmount += billPay.getAmount();
        }
        return totalAmount;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorId='" + vendorId + '\'' +
                ", billPayList=" + billPayList +
                ", vendorName='" + vendorName + '\'' +
                '}';
    }

    public void addVendorBill(Bill billPay) {

    }

}
