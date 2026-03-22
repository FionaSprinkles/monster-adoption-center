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
    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "species")
    private String species;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Min(0)@Max(10)
    @Column(name = "danger_level")
    private int dangerLevel;

    @Min(0)@Max(10)
    @Column(name = "tamed_level")
    private int tamedLevel;

    @Column(name = "adopted")
    private boolean adopted;
}
