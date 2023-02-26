package com.uc.credit.sender;

import com.uc.credit.model.Message;
import com.uc.credit.model.entity.user.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsSender implements Sender {
    @Override
    public void send(Customer customer, Message message) {
        log.info("Alıcı : " + customer.getPhone());
        log.info("Message : " + message.getBody());
    }
}
