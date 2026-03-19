package com.github.fionasprinkles.monsteradoptioncenter.service;

import com.github.fionasprinkles.monsteradoptioncenter.MonsterMapper;
import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.entity.Monster;
import com.github.fionasprinkles.monsteradoptioncenter.repository.MonsterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * These are unit test for @MonsterService.
 *This class uses Mockito.
 *
 *
 */


@ExtendWith(MockitoExtension.class)
class MonsterServiceTest {


    @InjectMocks
    MonsterService monsterService;

    @Mock
    MonsterRepository monsterRepository;

    @Mock
    MonsterMapper monsterMapper;

    private Monster monster;
    private MonsterDTO monsterDTO;

    /**
     * Before each test this setup initializes new @Monster and @MonsterDTO.
     *
     */
    @BeforeEach
            void setUp() {

        monster = new Monster();
        monster.setId(1L);
        monster.setName("Fluffy");
        monster.setSpecies("Dragon");
        monster.setDescription("Fluffy is a fluffy dragon");
        monster.setArrivalDate(LocalDate.of(2026, 02,02));
        monster.setDangerLevel(3);
        monster.setTamedLevel(3);
        monster.setAdopted(false);

        monsterDTO = new MonsterDTO();
        monsterDTO.setId(1L);
        monsterDTO.setName("Fluffy");
        monsterDTO.setSpecies("Dragon");
        monsterDTO.setDescription("Fluffy is a fluffy dragon");
        monsterDTO.setArrivalDate(LocalDate.of(2026, 2,2));
        monsterDTO.setDangerLevel(3);
        monsterDTO.setTamedLevel(3);
        monsterDTO.setAdopted(false);
    }


    /**
     * Ensures that all monsters returned from repository
     * are mapped to DTOs and returned as a list.
     */
    @DisplayName("Should return a list of all monsters")
    @Test
    void findAll() {


        when(monsterRepository.findAll()).thenReturn(List.of(monster));
        when(monsterMapper.toDTO(monster)).thenReturn(monsterDTO);

        List<MonsterDTO> result = monsterService.findAll();

        verify(monsterRepository).findAll();
        verify(monsterMapper).toDTO(monster);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Fluffy");
    }

    @DisplayName("Should create new monster")
    @Test
    void createMonster() {

        CreateMonsterDTO createMonsterDTO = new CreateMonsterDTO();

        when(monsterMapper.toEntity(createMonsterDTO)).thenReturn(monster);
        when(monsterRepository.save(monster)).thenReturn(monster);
        when(monsterMapper.toDTO(monster)).thenReturn(monsterDTO);

        MonsterDTO result = monsterService.createMonster(createMonsterDTO);

        verify(monsterMapper).toEntity(createMonsterDTO);
        verify(monsterRepository).save(monster);
        verify(monsterMapper).toDTO(monster);

        assertThat(result).isEqualTo(monsterDTO);
    }

    @Test
    void findById() {
    }
}