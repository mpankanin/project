package com.conference.project.service;

import com.conference.project.model.Customer;
import com.conference.project.model.Exception.CustomerNotFoundException;
import com.conference.project.model.Exception.ReservationAlreadyAssignedException;
import com.conference.project.model.Lecture;
import com.conference.project.model.Reservation;
import com.conference.project.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ReservationService reservationService;


    public CustomerService(CustomerRepository customerRepository, ReservationService reservationService) {
        this.customerRepository = customerRepository;
        this.reservationService = reservationService;
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Not found: " + id + " customer."));
    }

    public Customer deleteCustomer(Long id){
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
        return customer;
    }

    public Customer editCustomerLogin(Long id, String login){
        Customer customer = getCustomer(id);
        customer.setLogin(login);
        return customer;
    }

    public Customer editCustomerEmail(Long id, String email){
        Customer customer = getCustomer(id);
        customer.setEmail(email);
        return customer;
    }

    public Customer addReservationToCustomer(Long customerId, Long reservationId){
        Customer customer = getCustomer(customerId);
        Reservation reservation = reservationService.getReservation(reservationId);
        if(Objects.nonNull(reservation.getCustomer()))
            throw new ReservationAlreadyAssignedException("Reservation: " + reservationId + " already assigned to: " + reservation.getCustomer().getId() + " customer.");
        customer.addReservation(reservation);
        reservation.setCustomer(customer);
        return customer;
    }

    public Customer removeReservationFromCustomer(Long customerId, Long reservationId){
        Customer customer = getCustomer(customerId);
        Reservation reservation = reservationService.getReservation(reservationId);
        customer.removeReservation(reservation);
        return customer;
    }

}
