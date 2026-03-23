package com.github.fionasprinkles.monsteradoptioncenter;


import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.UpdateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.entity.Monster;
import org.springframework.stereotype.Component;

@Component
public class MonsterMapper {


    /**
     * Converts CreateMonsterDTO to Monster entity.
     * Used when creating a new monster from form input.
     */
    public Monster toEntity(CreateMonsterDTO create) {
        Monster monster = new Monster();
        monster.setName(create.getName());
        monster.setImageUrl(create.getImageUrl());
        monster.setSpecies(create.getSpecies());
        monster.setDescription(create.getDescription());
        monster.setArrivalDate(create.getArrivalDate());
        monster.setDangerLevel(Integer.valueOf(create.getDangerLevel()));
        monster.setTamedLevel(Integer.valueOf(create.getTamedLevel()));

        return monster;

    }

    /**
     * Converts Monster entity to MonsterDTO.
     * Used when sending data to the UI (list page).
     */
    public MonsterDTO toDTO(Monster monster) {
        MonsterDTO monsterDTO = new MonsterDTO();
        monsterDTO.setId(monster.getId());
        monsterDTO.setName(monster.getName());
        monsterDTO.setImageUrl(monster.getImageUrl());
        monsterDTO.setSpecies(monster.getSpecies());
        monsterDTO.setDescription(monster.getDescription());
        monsterDTO.setArrivalDate(monster.getArrivalDate());
        monsterDTO.setDangerLevel(monster.getDangerLevel());
        monsterDTO.setTamedLevel(monster.getTamedLevel());
        monsterDTO.setAdopted(monster.isAdopted());
        return monsterDTO;

    }

    /**
     * Updates an existing Monster entity using UpdateMonsterDTO.
     * Used when editing a monster.
     */
    public void toUpdateDTO(Monster monster, UpdateMonsterDTO update) {

        monster.setName(update.getName());
        monster.setImageUrl(update.getImageUrl());
        monster.setSpecies(update.getSpecies());
        monster.setDescription(update.getDescription());
        monster.setArrivalDate(update.getArrivalDate());
        monster.setDangerLevel(update.getDangerLevel());
        monster.setTamedLevel(update.getTamedLevel());
        monster.setAdopted(update.isAdopted());

    }

    /**
     * Converts MonsterDTO to UpdateMonsterDTO.
     * Used to pre-fill edit form with existing values.
     */
    public UpdateMonsterDTO toUpdateFormDTO(MonsterDTO monster) {
        UpdateMonsterDTO dto = new UpdateMonsterDTO();

        dto.setName(monster.getName());
        dto.setImageUrl(monster.getImageUrl());
        dto.setSpecies(monster.getSpecies());
        dto.setDescription(monster.getDescription());
        dto.setArrivalDate(monster.getArrivalDate());
        dto.setDangerLevel(monster.getDangerLevel());
        dto.setTamedLevel(monster.getTamedLevel());
        dto.setAdopted(monster.isAdopted());

        return dto;
    }

}
