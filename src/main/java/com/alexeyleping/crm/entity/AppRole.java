package com.alexeyleping.crm.entity;


import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "approle")
public class AppRole {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id")
    private UUID id;

    @Column(name = "namerole")
    private String name;

    public AppRole() {
    }

    public AppRole(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    /*@Override
    public String getAuthority() {
        return getName();
    }
*/
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppRole appRole = (AppRole) o;
        return Objects.equals(id, appRole.id) && Objects.equals(name, appRole.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AppRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
