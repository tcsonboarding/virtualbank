package com.example.demo.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
/*	 public Account findAccountByNumber(String accountNumber);
	 public Account addAccount(Account account);
	 public List<Account> findAll();*/

}
