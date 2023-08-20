package com.alexeyleping.crm.controllers.dto;

import com.alexeyleping.crm.entity.AppRole;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record ReturnAppUserDto(UUID id,
                               String username,
                               String password,
                               LocalDate create,
                               LocalDate change,
                               String email,
                               String address,
                               String city,
                               String country,
                               String phone,
                               Set<AppRole> appRoles) { }
