package com.github.fionasprinkles.monsteradoptioncenter.controller;

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
    public String newMonster(@Valid @ModelAttribute CreateMonsterDTO createMonsterDTO, BindingResult bindingResult, @RequestParam("image") MultipartFile image) {
        if (bindingResult.hasErrors()) {
            return "monsters/new";
        } else {
            monsterService.createMonster(createMonsterDTO, image);
        }return "redirect:/monsters/list";
    }

    //Visa formulär för uppdatering
    @GetMapping("/edit/{id}")
    public String editMonsterForm(@PathVariable Long id, Model model) {
        MonsterDTO monster = monsterService.findById(id);
        model.addAttribute("updateMonsterDTO", monster);
        return "monsters/edit";
    }

    //Uppdatera objekt
    @PostMapping("/edit/{id}")
    public String editMonster(@PathVariable Long id, @Valid @ModelAttribute UpdateMonsterDTO updateMonsterDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "monsters/edit";
        }else {
            monsterService.updateMonster(id, updateMonsterDTO);
        }return "redirect:/monsters/list";
    }

    //Ta bort objekt
    @PostMapping("/delete/{id}")
    public String deleteMonster(@PathVariable Long id) {
        monsterService.deleteMonster(id);
        return "redirect:/monsters/list";
    }
}
