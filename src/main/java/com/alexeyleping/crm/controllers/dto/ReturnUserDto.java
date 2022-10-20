package com.alexeyleping.crm.controllers.dto;

import java.util.Date;

public class ReturnUserDto {
    Long id;
    String name;
    String dateOfCreationUser;
    Date dateOfChangeUser;
    Date emailAddress;
    String address;
    String city;
    String country;
    String phoneNumber;
    String role;

    public ReturnUserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfCreationUser() {
        return dateOfCreationUser;
    }

    public void setDateOfCreationUser(String dateOfCreationUser) {
        this.dateOfCreationUser = dateOfCreationUser;
    }

    public Date getDateOfChangeUser() {
        return dateOfChangeUser;
    }

    public void setDateOfChangeUser(Date dateOfChangeUser) {
        this.dateOfChangeUser = dateOfChangeUser;
    }

    public Date getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(Date emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
