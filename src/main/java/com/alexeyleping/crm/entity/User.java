package com.alexeyleping.crm.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "dateOdCreationUser")
    String dateOdCreationUser;

    @Column(name = "dateOfChangeUser")
    String dateOfChangeUser;

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

    public User() {
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

    public String getDateOdCreationUser() {
        return dateOdCreationUser;
    }

    public void setDateOdCreationUser(String dateOdCreationUser) {
        this.dateOdCreationUser = dateOdCreationUser;
    }

    public String getDateOfChangeUser() {
        return dateOfChangeUser;
    }

    public void setDateOfChangeUser(String dateOfChangeUser) {
        this.dateOfChangeUser = dateOfChangeUser;
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
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(dateOdCreationUser, user.dateOdCreationUser) && Objects.equals(dateOfChangeUser, user.dateOfChangeUser) && Objects.equals(emailAddress, user.emailAddress) && Objects.equals(address, user.address) && Objects.equals(city, user.city) && Objects.equals(country, user.country) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOdCreationUser, dateOfChangeUser, emailAddress, address, city, country, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOdCreationUser='" + dateOdCreationUser + '\'' +
                ", dateOfChangeUser='" + dateOfChangeUser + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
