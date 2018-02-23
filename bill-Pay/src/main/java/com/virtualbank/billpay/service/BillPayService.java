package com.virtualbank.billpay.service;

import com.virtualbank.billpay.domain.Bill;
import com.virtualbank.billpay.domain.Vendor;
import com.virtualbank.billpay.exception.BillNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualbank.billpay.repository.BillPayRepository;

import java.util.List;

@Service
public class BillPayService {

	@Autowired
	private BillPayRepository repository;

    public Bill createBill(Long vendorId, Bill bill) {
        Vendor vendor = new Vendor();
        vendor.setVendorId(vendorId);
        bill.setVendor(vendor);
        return repository.save(bill);
    }

	public Bill findByBillId(Long billId) {
        final Bill bill = repository.findOne(billId);
        if (null == bill){
            throw new BillNotFoundException(billId);
        }
        return bill;
	}

    public void deleteByBillId(Long billId) {
        if (null == repository.findOne(billId)){
            throw new BillNotFoundException(billId);
        }
        repository.delete(billId);
    }
}
