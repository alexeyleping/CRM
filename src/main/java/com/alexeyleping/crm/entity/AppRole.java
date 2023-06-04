package com.alexeyleping.crm.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@RequiredArgsConstructor
public class AppRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return getName();
    }
}
