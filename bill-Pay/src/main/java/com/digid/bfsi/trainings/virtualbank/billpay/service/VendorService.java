package com.digid.bfsi.trainings.virtualbank.billpay.service;

import com.digid.bfsi.trainings.virtualbank.billpay.domain.Bill;
import com.digid.bfsi.trainings.virtualbank.billpay.domain.Vendor;
import com.digid.bfsi.trainings.virtualbank.billpay.exception.VendorNotFoundException;
import com.digid.bfsi.trainings.virtualbank.billpay.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

	@Autowired
	private VendorRepository repository;

    public Vendor registerVendor(Vendor vendor) {
        return repository.save(vendor);
    }

	public Vendor findByVendorId(Long vendorId) {
		final Vendor vendor = repository.findOne(vendorId);
		if (null == vendor){
			throw new VendorNotFoundException(vendorId);
		}
		return vendor;
	}

	public Vendor addBill(Long vendorId, Bill billPay) {
		Vendor vendor = repository.findByVendorId(vendorId);
		vendor.addVendorBill(billPay);
		repository.save(vendor);
		return vendor;
	}

    public void deleteVendor(Long vendorId) {
        if (null == repository.findOne(vendorId)){
            throw new VendorNotFoundException(vendorId);
        }
        repository.delete(vendorId);
    }

	public List<Vendor> findVendors() {
    	return repository.findAll();
	}

    public List<Bill> findBills(Long vendorId) {
        if (null == repository.findOne(vendorId)){
            throw new VendorNotFoundException(vendorId);
        }
        return repository.findOne(vendorId).getBillPayList();
    }
}
