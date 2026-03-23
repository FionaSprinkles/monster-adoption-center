package com.github.fionasprinkles.monsteradoptioncenter.controller;

import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.service.MonsterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(MonsterController.class)
class MonsterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MonsterService monsterService;


@DisplayName("Should return monster list page")
@Test
void listMonsters() throws Exception {

    when(monsterService.findAll()).thenReturn(List.of(new MonsterDTO()));

    mockMvc.perform(get("/monsters"))
            .andExpect(status().isOk())
            .andExpect(view().name("monsters/list"))
            .andExpect(model().attributeExists("monsters"));
}

}
