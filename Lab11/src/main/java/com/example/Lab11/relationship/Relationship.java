package com.example.Lab11.relationship;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Relationship {
    @Id
    @SequenceGenerator(
            name = "relationshipName",
            sequenceName = "relationshipName",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "relationshipName"
    )
    private Long id;
    private Long idPerson1, idPerson2;

    public Relationship() { }

    public Relationship(Long idPerson1, Long idPerson2) {
        this.idPerson1 = idPerson1;
        this.idPerson2 = idPerson2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPerson1() {
        return idPerson1;
    }

    public void setIdPerson1(Long idPerson1) {
        this.idPerson1 = idPerson1;
    }

    public Long getIdPerson2() {
        return idPerson2;
    }

    public void setIdPerson2(Long isPerson2) {
        this.idPerson2 = isPerson2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relationship that = (Relationship) o;
        return idPerson1.equals(that.idPerson1) && idPerson2.equals(that.idPerson2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson1, idPerson2);
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", idPerson1=" + idPerson1 +
                ", idPerson2=" + idPerson2 +
                '}';
    }
}
