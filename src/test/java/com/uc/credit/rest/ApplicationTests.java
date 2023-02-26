package com.uc.credit.rest;

import com.uc.credit.rest.customer.CustomerControllerDeleteTest;
import com.uc.credit.rest.customer.CustomerControllerPostTest;
import com.uc.credit.rest.customer.CustomerControllerUpdateTest;
import com.uc.credit.rest.loanrequest.LoanRequestControllerPostTest;
import com.uc.credit.rest.score.ScoreControllerDeleteTest;
import com.uc.credit.rest.score.ScoreControllerPostTest;
import com.uc.credit.rest.score.ScoreControllerUpdateTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        //Customer
        CustomerControllerPostTest.class,
        CustomerControllerUpdateTest.class,
        CustomerControllerDeleteTest.class,
        //Score
        ScoreControllerPostTest.class,
        ScoreControllerUpdateTest.class,
        ScoreControllerDeleteTest.class,
        //LoanRequest
        LoanRequestControllerPostTest.class

})
public class ApplicationTests {
}
