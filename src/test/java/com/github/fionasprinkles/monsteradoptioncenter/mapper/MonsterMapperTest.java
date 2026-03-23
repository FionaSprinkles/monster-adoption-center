package com.github.fionasprinkles.monsteradoptioncenter.mapper;

import com.github.fionasprinkles.monsteradoptioncenter.MonsterMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MonsterMapperTest {

    private MonsterMapper monsterMapper;

    @BeforeEach
    void setUp() {
        monsterMapper = new MonsterMapper();
    }

    @DisplayName("Should map CreateMonsterDTO to Monster")
    @Test
    void toEntity() {
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