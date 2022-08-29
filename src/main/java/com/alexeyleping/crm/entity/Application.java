package com.alexeyleping.crm.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Column(name = "creator")
    String creator;

    @Column(name = "owner")
    String owner;

    @Column(name = "applicationType")
    Type applicationType;

    @Column(name = "description")
    String description;

    @Column(name = "dateCreated")
    Date dateCreated;

    @Column(name = "dateChanged")
    Date dateChanged;

    @Column(name = "price")
    float price;

    @Column(name = "userid")
    Long userId;

    public Application() {
    }

    public Application(int id, String creator, String owner) {
        this.id = id;
        this.creator = creator;
        this.owner = owner;
        this.applicationType = Type.valueOf("OPEN");
        this.dateCreated = getDateToday();
        this.dateChanged = getDateToday();
        this.price = 0;
    }

    enum Type{
        OPEN,
        CLOSED,
        INWORK
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Type getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(Type applicationType) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Float.compare(that.price, price) == 0 && Objects.equals(id, that.id) && Objects.equals(creator, that.creator) && Objects.equals(owner, that.owner) && Objects.equals(applicationType, that.applicationType) && Objects.equals(description, that.description) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateChanged, that.dateChanged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creator, owner, applicationType, description, dateCreated, dateChanged, price);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", creator='" + creator + '\'' +
                ", owner='" + owner + '\'' +
                ", applicationType='" + applicationType + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                ", price=" + price +
                '}';
    }

    protected Date getDateToday(){
        Date date = new Date();
        return date;
    }



}
