package com.uc.credit.controller;

import com.uc.credit.manager.LoanRequestManager;
import com.uc.credit.model.dto.customer.request.SaveCustomerRequest;
import com.uc.credit.model.dto.customer.request.UpdateCustomerRequest;
import com.uc.credit.model.dto.customer.response.CustomerResponse;
import com.uc.credit.model.dto.loanrequest.request.SaveLoanRequestRequest;
import com.uc.credit.model.dto.loanrequest.request.UpdateLoanRequestRequest;
import com.uc.credit.model.dto.loanrequest.response.LoanRequestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("loanRequest")
public class LoanRequestController {

    private final LoanRequestManager loanRequestManager;
    @PostMapping("/customer/{customerId}")
    public ResponseEntity<LoanRequestResponse> save(@PathVariable String customerId){
        return ResponseEntity.ok(loanRequestManager.save(customerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanRequestResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(loanRequestManager.getById(id));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<LoanRequestResponse>> getAll(){
        return ResponseEntity.ok(loanRequestManager.getAll());
    }
}
