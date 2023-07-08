package com.alexeyleping.crm.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "application")
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

    @Column(name = "created")
    private LocalDate create;

    @Column(name = "change")
    private LocalDate change;

    @Column(name = "price")
    private float price;

    public Application() {
    }

    public Application(UUID id, Long number, String creator, String owner, ApplicationStatus applicationType, String description, LocalDate create, LocalDate change, float price) {
        this.id = id;
        this.number = number;
        this.creator = creator;
        this.owner = owner;
        this.applicationType = applicationType;
        this.description = description;
        this.create = create;
        this.change = change;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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

    public LocalDate getCreate() {
        return create;
    }

    public void setCreate(LocalDate create) {
        this.create = create;
    }

    public LocalDate getChange() {
        return change;
    }

    public void setChange(LocalDate change) {
        this.change = change;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Float.compare(that.price, price) == 0 && Objects.equals(id, that.id) && Objects.equals(number, that.number) && Objects.equals(creator, that.creator) && Objects.equals(owner, that.owner) && applicationType == that.applicationType && Objects.equals(description, that.description) && Objects.equals(create, that.create) && Objects.equals(change, that.change);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, creator, owner, applicationType, description, create, change, price);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", number=" + number +
                ", creator='" + creator + '\'' +
                ", owner='" + owner + '\'' +
                ", applicationType=" + applicationType +
                ", description='" + description + '\'' +
                ", create=" + create +
                ", change=" + change +
                ", price=" + price +
                '}';
    }
}
