package com.github.fionasprinkles.monsteradoptioncenter.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateMonsterDTO {

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
    @Min(0)
    @Max(10)
    private Integer dangerLevel;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer tamedLevel;
}
