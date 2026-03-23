package com.github.fionasprinkles.monsteradoptioncenter.controller;

import com.github.fionasprinkles.monsteradoptioncenter.MonsterMapper;
import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.UpdateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.service.MonsterService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/monsters")
public class MonsterController {

    private final MonsterService monsterService;
    private final MonsterMapper monsterMapper;

    private static final String REDIRECT_MONSTERS = "redirect:/monsters";
    private static final String VIEW_LIST = "monsters/list";
    private static final String VIEW_NEW = "monsters/new";
    private static final String VIEW_EDIT = "monsters/edit";

    public MonsterController(MonsterService monsterService, MonsterMapper monsterMapper) {
        this.monsterService = monsterService;
        this.monsterMapper = monsterMapper;
    }


    //Lista objekt
    @GetMapping
    public String listAllMonsters(Model model) {
        model.addAttribute("monsters", monsterService.findAll());
        return VIEW_LIST;
    }

    //Visa formulär för nytt objekt
    @GetMapping("/new")
    public String newMonsterForm(Model model) {
        model.addAttribute("createMonsterDTO", new CreateMonsterDTO());
        return VIEW_NEW;
    }

    //Skapa objekt
    @PostMapping
    public String newMonster(@Valid @ModelAttribute CreateMonsterDTO createMonsterDTO, BindingResult bindingResult, @RequestParam("image") MultipartFile image) {
        if (bindingResult.hasErrors()) {
            return VIEW_NEW;
        } else {
            monsterService.createMonster(createMonsterDTO, image);
        }return REDIRECT_MONSTERS;
    }

    //Visa formulär för uppdatering
    @GetMapping("/edit/{id}")
    public String editMonsterForm(@PathVariable Long id, Model model) {
        MonsterDTO monster = monsterService.findById(id);

        UpdateMonsterDTO dto = monsterMapper.toUpdateFormDTO(monster);

        model.addAttribute("updateMonsterDTO", dto);
        model.addAttribute("id", id);

        return VIEW_EDIT;
    }

    //Uppdatera objekt
    @PostMapping("/edit/{id}")
    public String editMonster(@PathVariable Long id, @Valid @ModelAttribute UpdateMonsterDTO updateMonsterDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return VIEW_EDIT;
        }else {
            monsterService.updateMonster(id, updateMonsterDTO);
        }return REDIRECT_MONSTERS;
    }

    //Ta bort objekt
    @PostMapping("/delete/{id}")
    public String deleteMonster(@PathVariable Long id) {
        monsterService.deleteMonster(id);
        return REDIRECT_MONSTERS;
    }
}
