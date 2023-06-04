package com.alexeyleping.crm.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "appuser")
@RequiredArgsConstructor
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "create")
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


}
