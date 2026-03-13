package com.github.fionasprinkles.monsteradoptioncenter.entity;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "monster")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String species;
    private String description;
    private LocalDate arrivalDate;
    private int dangerLevel;
    private int tamedLevel;
    private boolean adopted;

    public Monster() {

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
