package com.github.fionasprinkles.monsteradoptioncenter.mapper;

import com.github.fionasprinkles.monsteradoptioncenter.MonsterMapper;
import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.entity.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class MonsterMapperTest {

    private MonsterMapper monsterMapper;

    @BeforeEach
    void setUp() {
        monsterMapper = new MonsterMapper();
    }

    @DisplayName("Should map CreateMonsterDTO to Monster")
    @Test
    void toEntity() {
        CreateMonsterDTO dto = new CreateMonsterDTO();
        dto.setName("Fluffy");
        dto.setSpecies("Dragon");
        dto.setDescription("Fluffy dragon");
        dto.setArrivalDate(LocalDate.of(2026, 1, 1));
        dto.setDangerLevel(5);
        dto.setTamedLevel(7);

        Monster result = monsterMapper.toEntity(dto);

        assertThat(result.getName()).isEqualTo("Fluffy");
        assertThat(result.getSpecies()).isEqualTo("Dragon");
        assertThat(result.getDescription()).isEqualTo("Fluffy dragon");
        assertThat(result.getArrivalDate()).isEqualTo(LocalDate.of(2026, 1, 1));
        assertThat(result.getDangerLevel()).isEqualTo(5);
        assertThat(result.getTamedLevel()).isEqualTo(7);
    }
    

    @DisplayName("Should map Monster to MonsterDTO")
    @Test
    void toDTO() {
    }

    @DisplayName("Should update monster from UpdateMonsterDTO")
    @Test
    void toUpdateDTO() {
    }
}