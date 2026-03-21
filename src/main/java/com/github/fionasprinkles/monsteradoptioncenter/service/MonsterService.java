package com.github.fionasprinkles.monsteradoptioncenter.service;

import com.github.fionasprinkles.monsteradoptioncenter.MonsterMapper;
import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.UpdateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.entity.Monster;
import com.github.fionasprinkles.monsteradoptioncenter.repository.MonsterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterService {

    private MonsterRepository monsterRepository;
    private MonsterMapper monsterMapper;

    public MonsterService(MonsterRepository monsterRepository, MonsterMapper monsterMapper) {
        this.monsterRepository = monsterRepository;
        this.monsterMapper = monsterMapper;
    }

    public List<MonsterDTO> findAll() {
        return monsterRepository.findAll().stream().map(monsterMapper::toDTO).toList();
    }
    public MonsterDTO createMonster(CreateMonsterDTO createMonsterDTO) {
        Monster monster = monsterMapper.toEntity(createMonsterDTO);
        monsterRepository.save(monster);
        return monsterMapper.toDTO(monster);
    }

    public MonsterDTO findById(Long id) {
        Monster monster = monsterRepository.findById(id).orElseThrow(() -> new RuntimeException("Monster not found"));

        return monsterMapper.toDTO(monster);


    }

    // Updates an existing monster using values from UpdateMonsterDTO.
    // The id is provided separately so UpdateMonsterDTO does not need an id field.
    public MonsterDTO updateMonster(Long id, UpdateMonsterDTO updateDTO) {
        Monster monster = monsterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Monster not found"));

        monsterMapper.toUpdateDTO(monster, updateDTO);

        monsterRepository.save(monster);

        return monsterMapper.toDTO(monster);
    }

}
