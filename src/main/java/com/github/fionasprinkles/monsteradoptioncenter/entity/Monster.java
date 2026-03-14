package com.github.fionasprinkles.monsteradoptioncenter.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private Long id;

    @NotBlank
    private String name;

    private String species;

    private String description;

    @NotNull
    private LocalDate arrivalDate;

    @Min(0)@Max(10)
    private int dangerLevel;

    @Min(0)@Max(10)
    private int tamedLevel;

    private boolean adopted;
}
