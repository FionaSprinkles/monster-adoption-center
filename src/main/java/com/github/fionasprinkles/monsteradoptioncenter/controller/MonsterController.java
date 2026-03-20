package com.github.fionasprinkles.monsteradoptioncenter.controller;

import com.github.fionasprinkles.monsteradoptioncenter.service.MonsterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monsters")
public class MonsterController {

    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }
}
