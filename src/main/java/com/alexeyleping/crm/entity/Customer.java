package com.alexeyleping.crm.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "dateOdCreationCustomer")
    String dateOdCreationCustomer;

    @Column(name = "dateOfChangeCustomer")
    String dateOfChangeCustomer;

    @Column
    String emailAddress;

    @Column
    String address;

    @Column
    String city;

    @Column
    String country;

    @Column
    String phoneNumber;

    public Customer() {
    }

    public Customer(Optional<Customer> id){
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

    public String getDateOdCreationCustomer() {
        return dateOdCreationCustomer;
    }

    public void setDateOdCreationCustomer(String dateOdCreationCustomer) {
        this.dateOdCreationCustomer = dateOdCreationCustomer;
    }

    public String getDateOfChangeCustomer() {
        return dateOfChangeCustomer;
    }

    public void setDateOfChangeCustomer(String dateOfChangeCustomer) {
        this.dateOfChangeCustomer = dateOfChangeCustomer;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(dateOdCreationCustomer, customer.dateOdCreationCustomer) && Objects.equals(dateOfChangeCustomer, customer.dateOfChangeCustomer) && Objects.equals(emailAddress, customer.emailAddress) && Objects.equals(address, customer.address) && Objects.equals(city, customer.city) && Objects.equals(country, customer.country) && Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOdCreationCustomer, dateOfChangeCustomer, emailAddress, address, city, country, phoneNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOdCreationCustomer='" + dateOdCreationCustomer + '\'' +
                ", dateOfChangeCustomer='" + dateOfChangeCustomer + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
