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

    @Min(0)
    @Max(10)
    private int dangerLevel;

    @Min(0)
    @Max(10)
    private int tamedLevel;

    private boolean adopted;
}
