package com.alexeyleping.crm.controllers.dto;

import java.util.Date;
import java.util.UUID;

public record UserDto(UUID id,
                      String name,
                      Date create,
                      Date change,
                      String email,
                      String address,
                      String city,
                      String country,
                      String phone) { }
