package com.github.fionasprinkles.monsteradoptioncenter.service;

import com.github.fionasprinkles.monsteradoptioncenter.MonsterMapper;
import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.UpdateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.entity.Monster;
import com.github.fionasprinkles.monsteradoptioncenter.exception.ResourceNotFoundExceptionHandler;
import com.github.fionasprinkles.monsteradoptioncenter.repository.MonsterRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public MonsterDTO createMonster(CreateMonsterDTO createMonsterDTO, MultipartFile image) {
        Monster monster = monsterMapper.toEntity(createMonsterDTO);
        if (!image.isEmpty()) {
            try {
                String filename = image.getOriginalFilename();

                Path path = Paths.get("src/main/resources/static/images/" + filename);

                Files.write(path, image.getBytes());

                monster.setImageUrl("/images/" + filename);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
                .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Monster not found"));

        monsterMapper.toUpdateDTO(monster, updateDTO);

        monsterRepository.save(monster);

        return monsterMapper.toDTO(monster);
    }


    public void deleteMonster(Long id) {
        if (!monsterRepository.existsById(id)) {
            throw new ResourceNotFoundExceptionHandler("Monster with id " + id + " not found");
        }
        monsterRepository.deleteById(id);
    }

}
