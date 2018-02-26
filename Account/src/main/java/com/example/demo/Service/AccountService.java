package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ExceptionHandling.AccountNotFoundException;
import com.example.demo.ExceptionHandling.NoAccountCreatedException;
import com.example.demo.Model.Account;
import com.example.demo.Model.RequestModels.AccountRequest;
import com.example.demo.Repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CreditScoreService creditScoreService;
	
	@Autowired
	CustomerService customerService;
	
	/**
     * Method which returns all the Accounts
     *  
     * @return List<Account> a list of all the Accounts
     */ 
	public List<Account> findAll(){
		return (List<Account>) accountRepository.findAll();
	}
	
	/**
     * Method which returns the Account associated with a given Account Id
     *  
     * @param accountId the Account Id of the Account we want to retrieve 
     * @return Account the Account with the Account Id we specify 
     * @throws core.exceptions.AccountNotFoundException
     */ 
	
	public Account findAccountById(Long accountId) throws AccountNotFoundException {
		Account myAccount =  accountRepository.findOne(accountId);
		if(myAccount == null) {
			throw new AccountNotFoundException(accountId);
		}
		return myAccount;
	}
	 /**
     * Method which creates a new Account
     *  
     * @param account the account we want to save
     * @return Account the newly saved Account 
     *  @throws core.exceptions.NoAccountCreatedException
     */ 
	
	public Account addAccount(Account account) throws NoAccountCreatedException {
		
		//return accountRepository.save(account);
		Account  myAccount = accountRepository.save(account);
		if(myAccount == null) {
			throw new NoAccountCreatedException();
		}
		return myAccount;
	}
	
	public Account addAccountFromRequest(AccountRequest accountRequest) throws NoAccountCreatedException {
		Account theAccount = new Account();
		String ssn = customerService.getSsn(accountRequest.getCustomerId());
		if(ssn == null) {
			return null;
		}
		String creditScore = creditScoreService.getCreditScore(ssn);
		
		if(creditScore == null) {
			return null;
		}
		
		theAccount.setAccountType(accountRequest.getAccountType());
		theAccount.setMinimumBalance(accountRequest.getMinimumBalance());
		theAccount.setMonthlyFee(accountRequest.getMonthlyFee());
		theAccount.setOverDruftLimit(accountRequest.getOverDruftLimit());
		theAccount.setOpeningBallance(accountRequest.getOpeningBallance());
		return addAccount(theAccount);
		
	}
	
	public Account updateAccountByOpeningBalance(String openingBallance, Long id) {
		
		Account myAccount=  accountRepository.updateAccountByOpeningBalance(openingBallance, id);
		
		if(myAccount == null) {
			throw new AccountNotFoundException(id);
		}
		return myAccount;
	}
	
	public Long deleteAccountByAccountId(Long id) {
	Account myAccount =  accountRepository.findOne(id);
	if(myAccount == null) {
		throw new AccountNotFoundException(id);
	}
	return accountRepository.deleteAccountByAccountId(id);
	}
}
