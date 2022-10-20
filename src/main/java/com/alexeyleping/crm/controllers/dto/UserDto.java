package com.alexeyleping.crm.controllers.dto;

import javax.persistence.Column;
import java.util.Date;

public class UserDto {
     Long id;
    String name;
    Date dateOfCreationUser;
    Date dateOfChangeUser;
    String email;
    String address;
    String city;
    String country;
    String phoneNumber;
    String role;

    public UserDto() {
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

    public Date getDateOfCreationUser() {
        return dateOfCreationUser;
    }

    public void setDateOfCreationUser(Date dateOfCreationUser) {
        this.dateOfCreationUser = dateOfCreationUser;
    }

    public Date getDateOfChangeUser() {
        return dateOfChangeUser;
    }

    public void setDateOfChangeUser(Date dateOfChangeUser) {
        this.dateOfChangeUser = dateOfChangeUser;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
