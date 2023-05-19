package com.conference.project.controller;


import com.conference.project.model.Customer;
import com.conference.project.model.dto.CustomerPlainDto;
import com.conference.project.model.dto.ReservationDto;
import com.conference.project.model.dto.ReservationPlainDto;
import com.conference.project.model.exception.CustomerAlreadyAssignedException;
import com.conference.project.model.exception.CustomerNotFoundException;
import com.conference.project.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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


    @PutMapping(value = "{id}")
    public ResponseEntity<CustomerPlainDto> updateEmail(@PathVariable final Long id,
                                                        @RequestBody final CustomerPlainDto customerPlainDto){
     Customer customer = customerService.editCustomerEmail(id, customerPlainDto.getEmail());
     return new ResponseEntity<>(CustomerPlainDto.from(customer), HttpStatus.OK);
    }


    /*
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){

        if(customerRepository.findAll().stream().anyMatch(c -> Objects.equals(c.getLogin(), theCustomer.getLogin())))
            throw new CustomerAlreadyAssignedException("Login already exists - " + theCustomer.getLogin());
        return customerRepository.save(theCustomer);
    }



     */


}
