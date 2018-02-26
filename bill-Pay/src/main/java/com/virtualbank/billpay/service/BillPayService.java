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

    /**
     * createBill method is used to pay bill for a registered vendor by vendorId
     * @param vendorId
     * @param bill
     * @return
     */

    public Bill createBill(Long vendorId, Bill bill) {
        Vendor vendor = new Vendor();
        vendor.setVendorId(vendorId);
        bill.setVendor(vendor);
        return repository.save(bill);
    }

    /**
     * createBills method is used to pay bills (Batch Insert) for a registered vendor by vendorId
     * @param vendorId
     * @param bills
     * @return
     */

    public List<Bill> createBills(Long vendorId, List<Bill> bills) {
        Vendor vendor = new Vendor();
        vendor.setVendorId(vendorId);
        bills.forEach(bill -> bill.setVendor(vendor));
        return repository.save(bills);
    }

    /**
     * findByBillId method is used to get bill by billId
     * @param billId
     * @return
     */

	public Bill findByBillId(Long billId) {
        final Bill bill = repository.findOne(billId);
        if (null == bill){
            throw new BillNotFoundException(billId);
        }
        return bill;
	}

    /**
     * deleteByBillId method is used to delete bill by billId
     * @param billId
     */

    public void deleteByBillId(Long billId) {
        if (null == repository.findOne(billId)){
            throw new BillNotFoundException(billId);
        }
        repository.delete(billId);
    }
}
