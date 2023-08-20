package com.alexeyleping.crm.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "appuser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created")
    private LocalDate create;

    @Column(name = "change")
    private LocalDate change;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "appuser_approle",
            joinColumns = @JoinColumn(name = "appuser_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "approle_id", referencedColumnName = "id")
    )
    private Set<AppRole> appRoles;

    public AppUser() {
    }

    public AppUser(UUID id, String username, String password, Date date, Date change, String email, String address, String city, String country, String phone, Set<AppRole> appRoles) {
    }

    public AppUser(UUID id, String username, String password, LocalDate create, LocalDate change, String email, String address, String city, String country, String phone, Set<AppRole> appRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.create = create;
        this.change = change;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.appRoles = appRoles;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreate() {
        return create;
    }

    public void setCreate(LocalDate create) {
        this.create = create;
    }

    public LocalDate getChange() {
        return change;
    }

    public void setChange(LocalDate change) {
        this.change = change;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<AppRole> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(Set<AppRole> appRoles) {
        this.appRoles = appRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password) && Objects.equals(create, appUser.create) && Objects.equals(change, appUser.change) && Objects.equals(email, appUser.email) && Objects.equals(address, appUser.address) && Objects.equals(city, appUser.city) && Objects.equals(country, appUser.country) && Objects.equals(phone, appUser.phone) && Objects.equals(appRoles, appUser.appRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, create, change, email, address, city, country, phone, appRoles);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", create=" + create +
                ", change=" + change +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", appRoles=" + appRoles +
                '}';
    }
}
