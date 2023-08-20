package com.alexeyleping.crm.controllers.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ReturnAppUserDto(UUID id,
                               String username,
                               LocalDate create,
                               LocalDate change,
                               String email,
                               String address,
                               String city,
                               String country,
                               String phone) {

}