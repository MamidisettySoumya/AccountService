package com.maveric.account.controller;



import com.maveric.account.model.Account;
import com.maveric.account.exception.CustomerException;
import com.maveric.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    AccountService accountservice;
    //create Account
    @PostMapping("/customers/{customerId}/accounts")
    public ResponseEntity<Account> createAccount(@PathVariable String customerId,
                                                 @RequestBody Account account) {
        if(customerId.equals(account.getCustomerId())){

            Account accountResponse = accountservice.createAccount(account);
            return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
        }
        else{
            throw new CustomerException("customer id should be same in request body and url");
        }

    }

    //deleteAccount
    @DeleteMapping("customers/{customerId}/accounts/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String customerId,
                                                @PathVariable String accountId) {

        String result = accountservice.deleteAccount(accountId);
        //delete balance and transaction details
        if(result!=null) {

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(accountId+"AccountIdNotFound", HttpStatus.NOT_FOUND);

        }
    }

    //getAccounts
    @GetMapping("/customers/{customerId}/accounts")
    public ResponseEntity<List<Account>> getAccounts(@PathVariable String customerId,
                                                     @RequestBody Account account) {

        if(customerId.equals(account.getCustomerId())){
            List<Account> accountDtoResponse = accountservice.getAccounts(customerId);
            return new ResponseEntity<>(accountDtoResponse, HttpStatus.OK);
        }
        else{
            throw new CustomerException("customer id should be same in request body and url");
        }

    }

}
