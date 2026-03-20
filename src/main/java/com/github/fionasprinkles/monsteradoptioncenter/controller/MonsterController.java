package com.github.fionasprinkles.monsteradoptioncenter.controller;

import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.service.MonsterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monsters")
public class MonsterController {

    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    //TODO GET/POST för:
    /**
     * • Lista objekt
     * • Visa formulär för nytt objekt
     * • Skapa objekt
     * • Visa formulär för uppdatering
     * • Uppdatera objekt
     * • Ta bort objekt
     */

    //Lista objekt
    @GetMapping
    public String listAllMonsters(Model model) {
        model.addAttribute("monsters", monsterService.findAll());
        return "monsters/list";
    }

    //Visa formulär för nytt objekt
    @GetMapping("/new")
    public String newMonster(Model model) {
        model.addAttribute("createMonsterDTO", new CreateMonsterDTO());
        return "monsters/create";
    }
}
