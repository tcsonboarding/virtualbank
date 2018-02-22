package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.ExceptionHandling.NoAccountCreatedException;
import com.example.demo.Model.Account;
import com.example.demo.Service.AccountService;
//import com.example.demo.Service.core;


@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	/**
     * Method which returns all the Accounts
     *  
     * @return List<Account> a list of all the Accounts
     */ 
	
	@RequestMapping(method = RequestMethod.GET, value = "/account") ResponseEntity<?> getAccounts() {
		List<Account> account = new ArrayList<>();
		for (Account acc : accountService.findAll()) {
			account.add(acc);
		}
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	/**
     * Method which returns the Account associated with a given Account Id
     *  
     * @param accountId the Account Id of the Account we want to retrieve 
     * @return Account the Account with the Account Id we specify 
     * @throws core.exceptions.AccountNotFoundException
     */ 
	
	@RequestMapping(method = RequestMethod.GET, value = "/account/{accountId}")
	ResponseEntity<?> getAccount(@PathVariable Long accountId) throws EntityNotFoundException {
		Account account = accountService.findAccountById(accountId);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	/**
     * Method which creates a new Account
     *  
     * @param account the account we want to save
     * @return Account the newly saved Account 
     *  @throws core.exceptions.NoAccountCreatedException
     */ 
	@RequestMapping(method = RequestMethod.POST, value = "/account/", produces = "application/json")
	ResponseEntity<?> addAccount(@RequestBody Account account) {
		try {
			 accountService.addAccount(account);
		} catch (NoAccountCreatedException acct) {
			acct.printStackTrace();
		}
		return new ResponseEntity<>(account, HttpStatus.CREATED);
	}

}
