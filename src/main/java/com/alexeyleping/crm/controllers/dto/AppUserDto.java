package com.alexeyleping.crm.controllers.dto;

import com.alexeyleping.crm.entity.AppRole;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public record AppUserDto(UUID id,
                         String username,
                         String password,
                         Date create,
                         Date change,
                         String email,
                         String address,
                         String city,
                         String country,
                         String phone,
                         Set<AppRole> appRoles) { }
