package com.uc.credit.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomUtils {
    public String randomCitizenId(){
        return RandomStringUtils.randomNumeric(11);
    }
    public String randomPhoneNumber(){
     //  return "+90546681"+(new Random().nextInt(7999)+1000);
        return "+9054"+ RandomStringUtils.randomNumeric(8);
    }
    public String randomFirstname(){
        return"Ali"+ RandomStringUtils.randomAlphabetic(5);
    }
    public String randomLastname(){
        return"Bakır"+ RandomStringUtils.randomAlphabetic(5);
    }
}
