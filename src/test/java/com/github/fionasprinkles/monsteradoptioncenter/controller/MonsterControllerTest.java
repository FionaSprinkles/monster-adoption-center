package com.github.fionasprinkles.monsteradoptioncenter.controller;

import com.github.fionasprinkles.monsteradoptioncenter.dto.MonsterDTO;
import com.github.fionasprinkles.monsteradoptioncenter.service.MonsterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    @DisplayName("Should show create monster page")
    @Test
    void showCreateForm() throws Exception {

        mockMvc.perform(get("/monsters/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("monsters/new"));
    }

    @DisplayName("Should create monster and redirect")
    @Test
    void createMonster() throws Exception {

        MockMultipartFile image =
                new MockMultipartFile(
                        "image",
                        "test.jpg",
                        "image/jpeg",
                        "fake-image".getBytes()
                );

        mockMvc.perform(multipart("/monsters")
                        .param("name", "Fluffy")
                        .file(image)
                        .param("species", "Dragon")
                        .param("description", "Cute")
                        .param("arrivalDate", "2026-01-01")
                        .param("dangerLevel", "3")
                        .param("tamedLevel", "8"))
                .andExpect(status().is3xxRedirection());

        verify(monsterService).createMonster(
                org.mockito.ArgumentMatchers.any(),
                org.mockito.ArgumentMatchers.any()
        );
    }

    @DisplayName("Should show edit page")
    @Test
    void showEditForm() throws Exception {

        when(monsterService.findById(1L)).thenReturn(new MonsterDTO());

        mockMvc.perform(get("/monsters/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("monsters/edit"));
    }

    @DisplayName("Should delete monster and redirect")
    @Test
    void deleteMonster() throws Exception {

        mockMvc.perform(post("/monsters/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/monsters/list"));

        verify(monsterService).deleteMonster(1L);
    }

}
