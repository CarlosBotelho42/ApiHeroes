package com.carlosb.herois.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Heroes implements Serializable {

    @Id
    private Integer id;

    private String name;
    private String universe;
    private Integer films;

    public Heroes() {
    }

    public Heroes(Integer id, String name, String universe, Integer films) {
        this.id = id;
        this.name = name;
        this.universe = universe;
        this.films = films;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public Integer getFilms() {
        return films;
    }

    public void setFilms(Integer films) {
        this.films = films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Heroes heroes = (Heroes) o;
        return Objects.equals(id, heroes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
