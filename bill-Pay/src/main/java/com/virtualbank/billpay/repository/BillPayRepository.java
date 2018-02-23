package com.virtualbank.billpay.repository;

import java.io.Serializable;
import java.util.List;

import com.virtualbank.billpay.domain.Bill;
import com.virtualbank.billpay.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPayRepository extends JpaRepository<Bill, Serializable> {
	//List<Bill> findByBillId(String vendorId);
}
