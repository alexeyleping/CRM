package com.alexeyleping.crm.controllers.dto;

import com.alexeyleping.crm.entity.ApplicationStatus;

import java.util.Date;

public class ReturnApplicationDto {
    Long id;
    String creator;
    String owner;
    ApplicationStatus applicationType;
    String description;
    Date dateCreated;
    Date dateChanged;
    float price;

    public ReturnApplicationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ApplicationStatus getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(ApplicationStatus applicationType) {
        this.applicationType = applicationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
