package com.github.fionasprinkles.monsteradoptioncenter.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UpdateMonsterDTO {

    @NotBlank
    @Size(max = 60)
    private String name;

    private String imageUrl;

    @Size(max = 60)
    private String species;

    @Size(max = 1000)
    private String description;

    @NotNull
    @PastOrPresent
    private LocalDate arrivalDate;

    @NotNull
    @PastOrPresent
    @Min(0)
    @Max(10)
    private int dangerLevel;

    @NotNull
    @Min(0)
    @Max(10)
    private int tamedLevel;

    private boolean adopted;
}
