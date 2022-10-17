package com.alexeyleping.crm.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "dateOfCreationCustomer")
    Date dateOfCreationCustomer;

    @Column(name = "dateOfChangeCustomer")
    Date dateOfChangeCustomer;

    @Column(name = "email")
    String email;

    @Column(name = "address")
    String address;

    @Column(name = "city")
    String city;

    @Column(name = "country")
    String country;

    @Column(name = "phoneNumber")
    String phoneNumber;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setEmail(String emailAddress) {
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
