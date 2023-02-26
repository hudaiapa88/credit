package com.uc.credit.sender;

import com.uc.credit.model.Message;
import com.uc.credit.model.entity.user.Customer;

public interface Sender {

    void send(Customer customer, Message message);

}
