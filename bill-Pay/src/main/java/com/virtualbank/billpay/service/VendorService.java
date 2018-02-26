package com.virtualbank.billpay.service;

import com.virtualbank.billpay.domain.Bill;
import com.virtualbank.billpay.domain.Vendor;
import com.virtualbank.billpay.exception.VendorNotFoundException;
import com.virtualbank.billpay.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

	@Autowired
	private VendorRepository repository;

    /**
     * registerVendor is used to add new Vendor
     * @param vendor
     * @return
     */

    public Vendor registerVendor(Vendor vendor) {
        return repository.save(vendor);
    }

    /**
     * findByVendorId is used to get vendor by vendorId
     * @param vendorId
     * @return
     */

	public Vendor findByVendorId(Long vendorId) {
		final Vendor vendor = repository.findOne(vendorId);
		if (null == vendor){
			throw new VendorNotFoundException(vendorId);
		}
		return vendor;
	}

    /**
     *
     * @param vendorId
     * @param billPay
     * @return
     */

	public Vendor addBill(Long vendorId, Bill billPay) {
		Vendor vendor = repository.findByVendorId(vendorId);
		vendor.addVendorBill(billPay);
		repository.save(vendor);
		return vendor;
	}

    /**
     * deleteVendor is used to delete vendor by vendorId
     * @param vendorId
     */

    public void deleteVendor(Long vendorId) {
        if (null == repository.findOne(vendorId)){
            throw new VendorNotFoundException(vendorId);
        }
        repository.delete(vendorId);
    }

    /**
     * findVendors is used to get all the registered Vendors
     * @return
     */

	public List<Vendor> findVendors() {
    	return repository.findAll();
	}

    /**
     * findBills is used to get all the bill for Vendor by vendorId
     * @param vendorId
     * @return
     */

    public List<Bill> findBills(Long vendorId) {
        if (null == repository.findOne(vendorId)){
            throw new VendorNotFoundException(vendorId);
        }
        return repository.findOne(vendorId).getBillPayList();
    }
}
