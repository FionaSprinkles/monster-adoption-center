package com.github.fionasprinkles.monsteradoptioncenter.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "monster")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
