package com.alexeyleping.crm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "dateOfCreationUser")
    private Date dateOfCreationUser;

    @Column(name = "dateOfChangeUser")
    private Date dateOfChangeUser;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToMany(fetch = EAGER)
    private Collection<UserRole> roles = new ArrayList<>();

    public AppUser() {
    }

    public AppUser(int id, String login, String password, String name, Date dateOfCreationUser, Date dateOfChangeUser, String email, String address, String city, String country, String phoneNumber, Collection<UserRole> roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.dateOfCreationUser = dateOfCreationUser;
        this.dateOfChangeUser = dateOfChangeUser;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }


    public Collection<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<UserRole> roles) {
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) && Objects.equals(name, appUser.name) && Objects.equals(dateOfCreationUser, appUser.dateOfCreationUser) && Objects.equals(dateOfChangeUser, appUser.dateOfChangeUser) && Objects.equals(email, appUser.email) && Objects.equals(address, appUser.address) && Objects.equals(city, appUser.city) && Objects.equals(country, appUser.country) && Objects.equals(phoneNumber, appUser.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfCreationUser, dateOfChangeUser, email, address, city, country, phoneNumber);
    }

    @Override
    public String toString() {
        return "AppUser{" +
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
