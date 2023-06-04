package com.alexeyleping.crm.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "application")
@Data
@RequiredArgsConstructor
public class Application {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;

    @Column(name = "number")
    private Long number;

    @Column(name = "creator")
    private String creator;

    @Column(name = "owner")
    private String owner;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationType;

    @Column(name = "description")
    private String description;

    @Column(name = "create")
    private LocalDate create;

    @Column(name = "change")
    private LocalDate change;

    @Column(name = "price")
    private float price;

}
