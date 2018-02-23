package com.digid.bfsi.trainings.virtualbank.billpay.repository;

import com.digid.bfsi.trainings.virtualbank.billpay.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Serializable> {
	Vendor findByVendorId(Long vendorId);
}
