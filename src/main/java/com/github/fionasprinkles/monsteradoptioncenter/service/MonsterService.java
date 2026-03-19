package com.github.fionasprinkles.monsteradoptioncenter.service;

import com.github.fionasprinkles.monsteradoptioncenter.MonsterMapper;
import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
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

    public List<MonsterDTO> findById(Long id) {
        try {
            return monsterRepository.findById(id).stream().map(monsterMapper::toDTO).toList();
        }catch (Exception e){
            throw new RuntimeException("Monster not found");
        }


    }



}
