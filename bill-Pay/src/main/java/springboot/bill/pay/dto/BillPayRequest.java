package springboot.bill.pay.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class BillPayRequest {

    private String billType;
    // Formats output date when this DTO is passed through JSON
    @JsonFormat(pattern = "mmddyyyy")
    // Allows dd/MM/yyyy date to be passed into GET request in JSON
    @DateTimeFormat(pattern = "mmddyyyy")
    private Date payDay;

    private BigDecimal amount;

    public BillPayRequest(String billType, Date payDay, BigDecimal amount) {
        this.billType = billType;
        this.payDay = payDay;
        this.amount = amount;
    }

    public BillPayRequest() {
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
        return "BillPayRequest{" +
                "billType='" + billType + '\'' +
                ", payDay=" + payDay +
                ", amount=" + amount +
                '}';
    }
}
