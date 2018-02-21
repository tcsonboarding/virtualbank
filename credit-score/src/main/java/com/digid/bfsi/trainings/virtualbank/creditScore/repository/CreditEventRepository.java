package com.digid.bfsi.trainings.virtualbank.creditScore.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digid.bfsi.trainings.virtualbank.creditScore.domain.CreditEvent;

public interface CreditEventRepository extends JpaRepository<CreditEvent, Serializable> {
	List<CreditEvent> findBySsn(String ssn);
}
