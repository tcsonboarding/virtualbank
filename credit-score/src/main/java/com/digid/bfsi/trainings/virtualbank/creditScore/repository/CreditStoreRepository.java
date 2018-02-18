package com.digid.bfsi.trainings.virtualbank.creditScore.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digid.bfsi.trainings.virtualbank.creditScore.domain.CreditScore;

@Repository
public interface CreditStoreRepository extends JpaRepository<CreditScore, Serializable> {
	CreditScore findBySsn(String ssn);
}
