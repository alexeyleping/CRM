package com.alexeyleping.crm.controllers.dto;

import com.alexeyleping.crm.entity.ApplicationStatus;

import java.time.LocalDate;
import java.util.UUID;

public record ApplicationDto(UUID id,
                             Long number,
                             String creator,
                             String owner,
                             ApplicationStatus applicationType,
                             String description,
                             LocalDate create,
                             LocalDate change,
                             float price) {
}

