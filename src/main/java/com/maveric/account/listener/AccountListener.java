package com.maveric.account.listener;

import com.maveric.account.model.Account;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;



@Component
    public class AccountListener extends AbstractMongoEventListener<Account> {


        public void onBeforeConvert(BeforeConvertEvent<Account> event) {
            super.onBeforeConvert(event);

            LocalDateTime dateNow = LocalDateTime.now();

            event.getSource().setCreatedAt(dateNow);
            event.getSource().setUpdatedAt(dateNow);
        }
    }


