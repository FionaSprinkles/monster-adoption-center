package com.github.fionasprinkles.monsteradoptioncenter.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MonsterDTO {

    private Long id;

    @NotBlank
    private String name;

    private String imageUrl;

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
