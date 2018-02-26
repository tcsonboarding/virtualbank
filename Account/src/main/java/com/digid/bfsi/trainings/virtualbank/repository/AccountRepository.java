package com.example.demo.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	 
	/* @Modifying
	 @Transactional
	 @Query("DELETE Account a from a WHERE a.id=?id ")
	 public Account deleteAccount(Long id);
	 @Modifying
	 @Transactional
	 @Query("DELETE Account a from a WHERE a.id=?id ")
	 public Account updateAccount(Long id);*/
	 
	 @Transactional
	 public Long deleteAccountByAccountId(Long id);
	 
	 @Transactional
	 @Modifying
	 @Query("UPDATE Account a set a.openingBallance = ? 1 where a.accountId= ? 2")
	 public Account updateAccountByOpeningBalance(String openingBallance, Long id);

}
