package com.maveric.account.service;

import com.maveric.account.exception.AccountNotFoundException;
import com.maveric.account.model.Account;
import com.maveric.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountrepository;

    public Account createAccount(Account account) {
        Account accountResponse = accountrepository.save(account);
        return  accountResponse;
    }

    @Override
    public List<Account> getAccounts(String customerId) {
        return null;
    }

    @Override
    public Account getAccountDetailsById(String customerId, String accountId) {
        return null;
    }

    @Override
    public String deleteAccount(String accountId) {
        if(!accountrepository.findById(accountId).isPresent())
        {
            throw new AccountNotFoundException("Account not found for Id-"+accountId);
        }
        accountrepository.deleteById(accountId);
        return "Account deleted successfully";
    }

}
