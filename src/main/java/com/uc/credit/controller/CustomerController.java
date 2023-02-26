package com.uc.credit.controller;

import com.uc.credit.manager.CustomerManager;
import com.uc.credit.model.dto.customer.request.SaveCustomerRequest;
import com.uc.credit.model.dto.customer.request.UpdateCustomerRequest;
import com.uc.credit.model.dto.customer.response.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {
    private final CustomerManager customerManager;

    @PostMapping
    public ResponseEntity<CustomerResponse> save(@RequestBody @Valid SaveCustomerRequest saveCustomerRequest){
        return ResponseEntity.ok(customerManager.save(saveCustomerRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable String id, @RequestBody @Valid UpdateCustomerRequest updateCustomerRequest){
        return ResponseEntity.ok(customerManager.update(id,updateCustomerRequest));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
         customerManager.delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(customerManager.getById(id));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerResponse>> getAll(){
        return ResponseEntity.ok(customerManager.getAll());
    }
}
