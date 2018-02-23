package springboot.bill.pay.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class BillPayVendor {

    @Id
    @GeneratedValue
    private Long vendorId;
    private String vendorName;
    private String billType;

    @JsonIgnore
    @ManyToOne
    private Account account;
    // Formats output date when this DTO is passed through JSON
    @JsonFormat(pattern = "mmddyyyy")
    // Allows dd/MM/yyyy date to be passed into GET request in JSON
    @DateTimeFormat(pattern = "mmddyyyy")
    private Date payDay;

    private BigDecimal amount;

    public BillPayVendor(Account account, String vendorName, String billType, Date payDay, BigDecimal amount) {
        this.vendorName = vendorName;
        this.billType = billType;
        this.payDay = payDay;
        this.amount = amount;
        this.account = account;
    }

    public BillPayVendor() {
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Account getAccount() {
        return account;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BillPayVendor{" +
                "vendorId=" + vendorId +
                ", vendorName='" + vendorName + '\'' +
                ", billType='" + billType + '\'' +
                ", account=" + account +
                ", payDay=" + payDay +
                ", amount=" + amount +
                '}';
    }
}
