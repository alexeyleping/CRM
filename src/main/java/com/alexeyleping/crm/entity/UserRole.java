package com.alexeyleping.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String role;

    public UserRole() {
    }

    public UserRole(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
