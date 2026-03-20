package com.github.fionasprinkles.monsteradoptioncenter;


import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.UpdateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.entity.Monster;
import org.springframework.stereotype.Component;

@Component
public class MonsterMapper {



    public Monster toEntity(CreateMonsterDTO create) {
        Monster monster = new Monster();
        monster.setName(create.getName());
        monster.setSpecies(create.getSpecies());
        monster.setDescription(create.getDescription());
        monster.setArrivalDate(create.getArrivalDate());
        monster.setDangerLevel(Integer.valueOf(create.getDangerLevel()));
        monster.setTamedLevel(Integer.valueOf(create.getTamedLevel()));

        return monster;

    }

    public MonsterDTO toDTO(Monster monster) {
        MonsterDTO monsterDTO = new MonsterDTO();
        monsterDTO.setId(monster.getId());
        monsterDTO.setName(monster.getName());
        monsterDTO.setSpecies(monster.getSpecies());
        monsterDTO.setDescription(monster.getDescription());
        monsterDTO.setArrivalDate(monster.getArrivalDate());
        monsterDTO.setDangerLevel(monster.getDangerLevel());
        monsterDTO.setTamedLevel(monster.getTamedLevel());
        monsterDTO.setAdopted(monster.isAdopted());
        return monsterDTO;

    }

    public UpdateMonsterDTO toUpdateDTO(Monster monster, UpdateMonsterDTO update) {

        monster.setName(update.getName());
        monster.setSpecies(update.getSpecies());
        monster.setDescription(update.getDescription());
        monster.setArrivalDate(update.getArrivalDate());
        monster.setDangerLevel(update.getDangerLevel());
        monster.setTamedLevel(update.getTamedLevel());
        monster.setAdopted(update.isAdopted());

        return update;
    }

}
