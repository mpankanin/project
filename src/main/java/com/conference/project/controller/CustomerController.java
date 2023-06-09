package com.conference.project.controller;


import com.conference.project.model.Customer;
import com.conference.project.model.dto.CustomerPlainDto;
import com.conference.project.model.exception.CustomerAlreadyAssignedException;
import com.conference.project.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerPlainDto> addCustomer(@RequestBody CustomerPlainDto customerPlainDto){
        if(customerService.getCustomers().stream().anyMatch(c -> Objects.equals(c.getLogin(), customerPlainDto.getLogin())))
            throw new CustomerAlreadyAssignedException("Login already exists");
        Customer customer = customerService.addCustomer(Customer.from(customerPlainDto));
        return new ResponseEntity<>(CustomerPlainDto.from(customer), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerPlainDto>> getCustomers(){
        List<CustomerPlainDto> result = customerService.getCustomers().stream().map(CustomerPlainDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerPlainDto> updateEmail(@PathVariable final Long id,
                                                        @RequestBody final CustomerPlainDto customerPlainDto){
     Customer customer = customerService.editCustomerEmail(id, customerPlainDto.getEmail());
     return new ResponseEntity<>(CustomerPlainDto.from(customer), HttpStatus.OK);
    }

}
