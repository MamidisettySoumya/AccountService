package com.maveric.account.service;

import com.maveric.account.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    public Account createAccount(Account account);

    public List<Account> getAccounts(String customerId);

    public Account getAccountDetailsById(String customerId, String accountId);

    public String deleteAccount(String accountId);
}
