package com.digid.bfsi.trainings.virtualbank.billpay.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Bill implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4150428252794113718L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @JsonIgnore
    private Vendor vendor;

    private String billType;
    private long amount;

    @JsonFormat(pattern = "mmddyyyy")
    // Allows mmddyyyy date to be passed into GET request in JSON
    @DateTimeFormat(pattern = "mmddyyyy")
    private Date payDay;

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public long getVendorId() {
        return vendor.getVendorId();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", billType='" + billType + '\'' +
                ", amount=" + amount +
                ", payDay=" + payDay +
                '}';
    }
}
