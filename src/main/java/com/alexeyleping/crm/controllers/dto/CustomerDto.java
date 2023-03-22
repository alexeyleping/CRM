package com.alexeyleping.crm.controllers.dto;

import java.util.Date;

public class CustomerDto {

    int id;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String name;
    Date dateOfCreationCustomer;
    Date dateOfChangeCustomer;
    String email;
    String address;
    String city;
    String country;
    String phoneNumber;

    public CustomerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfCreationCustomer() {
        return dateOfCreationCustomer;
    }

    public void setDateOfCreationCustomer(Date dateOfCreationCustomer) {
        this.dateOfCreationCustomer = dateOfCreationCustomer;
    }

    public Date getDateOfChangeCustomer() {
        return dateOfChangeCustomer;
    }

    public void setDateOfChangeCustomer(Date dateOfChangeCustomer) {
        this.dateOfChangeCustomer = dateOfChangeCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
