package com.uc.credit.util.db;

import com.uc.credit.model.entity.Address;
import com.uc.credit.model.entity.Score;
import com.uc.credit.model.entity.account.CreditAccount;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.repository.CreditAccountRepository;
import com.uc.credit.repository.CustomerRepository;
import com.uc.credit.repository.LoanRequestRepository;
import com.uc.credit.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;

@Transactional
@Component
@RequiredArgsConstructor
public class DbLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CreditAccountRepository creditAccountRepository;
    private final ScoreRepository scoreRepository;
    
    private final LoanRequestRepository loanRequestRepository;

    @Override
    public void run(String... args) throws Exception {
        if (0 == customerRepository.count()) {
            Customer customer = new Customer();
            customer.setFirstname("Hüdai");
            customer.setLastname("Apa");
            customer.setCitizenId("21645678852");
            customer.setPhone("+905469635689");
            customer.setBirthDate(LocalDate.now());
            customer.setMonthlyIncome(new BigDecimal(4500));
            Address address= new Address();
            address.setProvince("Denizli");
            address.setCountry("Türkiye");
            address.setDistrict("Pamukkale");
            address.setNeighborhood("Asmalıevler");
            address.setStreet("6661");
            address.setBuildingInformation("No:23 Kat:1 Daire:1");
            customer.setAddress(address);
            customer = customerRepository.save(customer);
            Score score = new Score();
            score.setCustomer(customer);
            score.setAmount(950L);
            scoreRepository.save(score);

            CreditAccount creditAccount = new CreditAccount();
            creditAccount.setCutOffDate(LocalDate.now());
            creditAccount.setLimit(new BigDecimal(10000));
            creditAccount.setBalance(new BigDecimal(8000));
            creditAccount.setCustomer(customer);
            creditAccountRepository.save(creditAccount);
        }
    }
}
