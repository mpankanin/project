package com.conference.project.controller;


import com.conference.project.service.CustomerService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
