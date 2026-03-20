package com.github.fionasprinkles.monsteradoptioncenter.controller;

import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.service.MonsterService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monsters")
public class MonsterController {

    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }


    //Lista objekt
    @GetMapping
    public String listAllMonsters(Model model) {
        model.addAttribute("monsters", monsterService.findAll());
        return "monsters/list";
    }

    //Visa formulär för nytt objekt
    @GetMapping("/new")
    public String newMonsterForm(Model model) {
        model.addAttribute("createMonsterDTO", new CreateMonsterDTO());
        return "monsters/new";
    }

    //Skapa objekt
    @PostMapping
    public String newMonster(@Valid @ModelAttribute CreateMonsterDTO createMonsterDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "monsters/new";
        } else {
            monsterService.createMonster(createMonsterDTO);
        }return "redirect:/monsters/list";
    }

    //Visa formulär för uppdatering

    //Uppdatera objekt

    //Ta bort objekt
}
