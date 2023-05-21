package com.conference.project.model.dto;

import com.conference.project.model.Customer;

public class CustomerPlainDto {

    private Long id;
    private String login;
    private String email;

    public CustomerPlainDto() {
    }

    public CustomerPlainDto(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public CustomerPlainDto(Long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

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

    public static CustomerPlainDto from(Customer customer){
        CustomerPlainDto customerPlainDto = new CustomerPlainDto();
        customerPlainDto.setId(customer.getId());
        customerPlainDto.setLogin(customer.getLogin());
        customerPlainDto.setEmail(customer.getEmail());
        return customerPlainDto;
    }

}
