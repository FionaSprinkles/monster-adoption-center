package com.github.fionasprinkles.monsteradoptioncenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(MonsterController.class)
class MonsterControllerTest {

    @Autowired
    private MockMvc mockMvc;
}
