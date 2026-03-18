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

        update.setName(monster.getName());
        update.setSpecies(monster.getSpecies());
        update.setDescription(monster.getDescription());
        update.setArrivalDate(monster.getArrivalDate());
        update.setDangerLevel(monster.getDangerLevel());
        update.setTamedLevel(monster.getTamedLevel());
        update.setAdopted(monster.isAdopted());

        return update;
    }

}
