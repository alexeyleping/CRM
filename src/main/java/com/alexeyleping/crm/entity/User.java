package com.alexeyleping.crm.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "dateOfCreationUser")
    Date dateOfCreationUser;

    @Column(name = "dateOfChangeUser")
    Date dateOfChangeUser;

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

    @Column(name = "role")
    String role;


    public User() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(dateOfCreationUser, user.dateOfCreationUser) && Objects.equals(dateOfChangeUser, user.dateOfChangeUser) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(city, user.city) && Objects.equals(country, user.country) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfCreationUser, dateOfChangeUser, email, address, city, country, phoneNumber, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOdCreationUser='" + dateOfCreationUser + '\'' +
                ", dateOfChangeUser='" + dateOfChangeUser + '\'' +
                ", emailAddress='" + email+ '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
