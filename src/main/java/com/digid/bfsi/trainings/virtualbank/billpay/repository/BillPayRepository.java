package com.digid.bfsi.trainings.virtualbank.billpay.repository;

import java.io.Serializable;
import java.util.List;

import com.digid.bfsi.trainings.virtualbank.billpay.domain.Bill;
import com.digid.bfsi.trainings.virtualbank.billpay.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPayRepository extends JpaRepository<Bill, Serializable> {
	//List<Bill> findByBillId(String vendorId);
}
