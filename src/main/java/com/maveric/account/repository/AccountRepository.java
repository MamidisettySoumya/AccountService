package com.maveric.account.repository;


import com.maveric.account.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findBycustomerId(String customerId);

    @Query("{'customerId':?0, '_id':?1}")
    Account findAccountByCustomerId(String customerId, String accountId);

}
