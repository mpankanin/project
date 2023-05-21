package com.conference.project.model.dto;

import com.conference.project.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDto {

    private Long id;
    private String login;
    private String email;
    private List<ReservationDto> reservationsDto = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReservationDto> getReservationsDto() {
        return reservationsDto;
    }

    public void setReservationsDto(List<ReservationDto> reservationsDto) {
        this.reservationsDto = reservationsDto;
    }

    public static CustomerDto from(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setLogin(customer.getLogin());
        customerDto.setEmail(customer.getEmail());
        customerDto.setReservationsDto(customer.getReservations().stream().map(ReservationDto::from).collect(Collectors.toList()));
        return customerDto;
    }

}
